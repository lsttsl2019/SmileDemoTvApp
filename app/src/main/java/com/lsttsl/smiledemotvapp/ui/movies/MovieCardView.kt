package com.lsttsl.smiledemotvapp.ui.movies

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.lsttsl.smiledemotvapp.R
import com.lsttsl.smiledemotvapp.dagger.modules.HttpClientModule
import com.lsttsl.smiledemotvapp.data.models.Movie
import com.lsttsl.smiledemotvapp.ui.base.BindableCardView
import kotlinx.android.synthetic.main.card_movie.view.*
import okhttp3.internal.format
import java.lang.String
import java.util.*

class MovieCardView(context: Context?) :
    BindableCardView<Movie?>(context) {


    public override fun bind(data: Movie?) {
        Glide.with(context)
            .load(HttpClientModule.POSTER_URL + data!!.posterPath)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(poster_iv)
        val format = Locale.getDefault()
        vote_average_tv.text = String.format(format , "%.2f",data.voteAverage)
    }

    fun getPosterIV(): ImageView? { return poster_iv}


    override val layoutResource: Int
        get() = R.layout.card_movie

}