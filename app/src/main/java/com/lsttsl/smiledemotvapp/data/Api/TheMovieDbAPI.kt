package com.lsttsl.smiledemotvapp.data.Api


import com.lsttsl.smiledemotvapp.dagger.modules.HttpClientModule
import com.lsttsl.smiledemotvapp.data.models.*
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import rx.Observable

interface TheMovieDbAPI {
    @GET(HttpClientModule.NOW_PLAYING)
    fun getNowPlayingMovies(
        @Query("api_key") apiKey: String?,
        @Query("page") page: Int
    ): Observable<MovieResponse?>?

    @GET(HttpClientModule.TOP_RATED)
    fun getTopRatedMovies(
        @Query("api_key") apiKey: String?,
        @Query("page") page: Int
    ): Observable<MovieResponse?>?

    @GET(HttpClientModule.UPCOMING)
    fun getUpcomingMovies(
        @Query("api_key") apiKey: String?,
        @Query("page") page: Int
    ): Observable<MovieResponse?>?

    @GET(HttpClientModule.POPULAR)
    fun getPopularMovies(
        @Query("api_key") apiKey: String?,
        @Query("page") page: Int
    ): Observable<MovieResponse?>?

    @GET(HttpClientModule.MOVIE + "{id}/similar")
    fun getSimilarMovies(
        @Path("id") movieId: String?,
        @Query("api_key") apiKey: String?
    ): Observable<MovieResponse?>?

    @GET(HttpClientModule.MOVIE + "{id}/recommendations")
    fun getRecommendations(
        @Path("id") movieId: String?,
        @Query("api_key") apiKey: String?
    ): Observable<MovieResponse?>?

    @GET(HttpClientModule.MOVIE + "{id}/credits")
    fun getCredits(
        @Path("id") movieId: String?,
        @Query("api_key") apiKey: String?
    ): Observable<CreditsResponse?>?

    @GET(HttpClientModule.MOVIE + "{id}")
    fun getMovieDetails(
        @Path("id") movieId: String?,
        @Query("api_key") apiKey: String?
    ): Observable<MovieDetails?>?

    @GET(HttpClientModule.MOVIE + "{id}/videos")
    fun getMovieVideos(
        @Path("id") movieId: String?,
        @Query("api_key") apiKey: String?
    ): Observable<VideoResponse?>?

    @GET(HttpClientModule.PERSON + "{id}")
    fun getPerson(
        @Path("id") personId: Int,
        @Query("api_key") apiKey: String?
    ): Observable<Person?>?

    @GET(HttpClientModule.DISCOVER)
    fun getMoviesForCastID(
        @Query("with_cast") castId: Int,
        @Query("api_key") apiKey: String?
    ): Observable<MovieResponse?>?

    @GET(HttpClientModule.SEARCH_MOVIE)
    fun searchMovies(
        @Query("query") query: String?,
        @Query("api_key") apiKey: String?
    ): Observable<MovieResponse?>?
}
