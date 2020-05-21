package com.lsttsl.smiledemotvapp.ui.main

import android.os.Bundle
import android.util.Log
import android.util.SparseArray
import androidx.core.content.ContextCompat
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.*
import com.lsttsl.smiledemotvapp.App
import com.lsttsl.smiledemotvapp.Config
import com.lsttsl.smiledemotvapp.R
import com.lsttsl.smiledemotvapp.dagger.modules.HttpClientModule
import com.lsttsl.smiledemotvapp.data.Api.TheMovieDbAPI
import com.lsttsl.smiledemotvapp.data.models.Movie
import com.lsttsl.smiledemotvapp.data.models.MovieResponse
import com.lsttsl.smiledemotvapp.ui.base.GlideBackgroundManager
import com.lsttsl.smiledemotvapp.ui.movies.MoviePresenter
import com.squareup.moshi.Json
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject
import kotlin.math.log


class MainFragment : BrowseSupportFragment(), OnItemViewSelectedListener {

      var mDbAPI: TheMovieDbAPI? =null
        @Inject set

    private var mBackgroundManager: GlideBackgroundManager? = null

    private val NOW_PLAYING = 0
    private val TOP_RATED = 1
    private val POPULAR = 2
    private val UPCOMING = 3

    var mRows: SparseArray<MovieRow>? = null

    companion object {

        fun newInstance(): MainFragment {
            val args = Bundle()
            val fragment = MainFragment()
            fragment.arguments = args
            return fragment
        }


    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        App.instance()!!.appComponent()

        mBackgroundManager = GlideBackgroundManager(activity!!)


        brandColor = ContextCompat.getColor(activity!!, R.color.primary_transparent )
        headersState = HEADERS_ENABLED
        isHeadersTransitionOnBackEnabled = true

        badgeDrawable = ContextCompat.getDrawable(activity!!, R.drawable.powered_by)

        createDateRows()
        createRow()
        prepareEntranceTransition()

     //   Log.d("TAGss" , "$mDbAPI!!.getNowPlayingMovies(Config.API_KEY_URL, mRows!![TOP_RATED].getPage()).toString() ")


        fetchNowPlayingMovies()
        fetchTopRatedMovies()
        fetchPopularMovies()
        fetchUpcomingMovies()

    }

    // 여기서 화면 text 변경
    fun createDateRows() {
        mRows = SparseArray()

        val moviePresenter = MoviePresenter()
        mRows!!.put(
            NOW_PLAYING,
            MovieRow().setId(NOW_PLAYING)!!.setAdapter(ArrayObjectAdapter(moviePresenter))!!
                .setTitle("NowPlaying")!!.setPage(1)
        )

        mRows!!.put(
            TOP_RATED,
            MovieRow().setId(TOP_RATED)!!.setAdapter(ArrayObjectAdapter(moviePresenter))!!
                .setTitle("Top Rated")!!.setPage(1)
        )

        mRows!!.put(
            POPULAR, MovieRow()
                .setId(POPULAR)!!.setAdapter(ArrayObjectAdapter(moviePresenter))
            !!.setTitle("Popular")
            !!.setPage(1)
        )
        mRows!!.put(
            UPCOMING, MovieRow()
                .setId(UPCOMING)
            !!.setAdapter(ArrayObjectAdapter(moviePresenter))
            !!.setTitle("Upcoming")
            !!.setPage(1)
        )
    }

    private fun createRow() {
        val rowsAdapter = ArrayObjectAdapter(ListRowPresenter())

        for (i in 0 until mRows!!.size()) {
            val row = mRows!!.get(i)

            val headerItem = HeaderItem(row.getId().toLong(), row.getTitle())
            val listRow = ListRow(headerItem, row.getAdapter())
            rowsAdapter.add(listRow)
        }
        adapter = rowsAdapter
        onItemViewSelectedListener = this
    }

    //API 연결
    private fun fetchNowPlayingMovies() {


        mDbAPI!!.getNowPlayingMovies(Config.API_KEY_URL, mRows!![NOW_PLAYING].getPage())
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe({ response ->
                bindMovieResponse(response!!, NOW_PLAYING)
                startEntranceTransition()
            }) { e -> Timber.e(e, "Error fetching top rated movies: %s", e.message) }
    }

    private fun fetchTopRatedMovies(){
        mDbAPI!!.getTopRatedMovies(Config.API_KEY_URL, mRows!![TOP_RATED].getPage())
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe({ response ->
                bindMovieResponse(response!!,TOP_RATED)
                startEntranceTransition()
            }) { e -> Timber.e(e, "Error fetching top rated movies: %s", e.message) }

    }

    private fun fetchPopularMovies(){
        mDbAPI!!.getPopularMovies(Config.API_KEY_URL, mRows!![POPULAR].getPage())
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe( {response ->
                bindMovieResponse(response!!, POPULAR)
                startEntranceTransition()
            } ){ e ->Timber.e( "Error fetching popular movies: %s", e.message)}
    }

    private fun fetchUpcomingMovies(){
        mDbAPI!!.getTopRatedMovies(Config.API_KEY_URL, mRows!!.get(UPCOMING).getPage())
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe({ response ->
                bindMovieResponse(response!!, UPCOMING)
                startEntranceTransition()
            }){ e -> Timber.e("Error fetching top rated movies: %s" , e.message)}
    }



    private fun bindMovieResponse(response: MovieResponse, id: Int) {
        val row = mRows!!.get(id)
        row.setPage(row.getPage() + 1)
        for (m in response.getResults()!!) {
            if (m.posterPath != null) { // Avoid showing movie without posters
                row.getAdapter()!!.add(m)
            }
        }

    }

    override fun onItemSelected(
        itemViewHolder: Presenter.ViewHolder?,
        item: Any?,
        rowViewHolder: RowPresenter.ViewHolder?,
        row: Row?
    ) {

        // Check if the item is a movie
        if (item is Movie) {
            val movie = item as Movie

            if (movie.backdropPath != null) {
                mBackgroundManager!!.loadImage(HttpClientModule.BACKDROP_URL + movie.backdropPath)
            } else {
                mBackgroundManager!!.setBackground(ContextCompat.getDrawable(activity!!, R.drawable.material_bg ))
            }
        }

    }

}































