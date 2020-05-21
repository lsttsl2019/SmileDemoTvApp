package com.lsttsl.smiledemotvapp.data.models

import android.os.Parcel
import android.os.Parcelable
import com.squareup.moshi.Json

class MovieDetails : Parcelable {
    var isAdult = false
        private set
    var overview: String? = null
        private set
    var isVideo = false
        private set
    var genres: List<Genre>? = null
        private set
    var title: String? = null
        private set
    var popularity = 0f
        private set
    var budget = 0
        private set
    var runtime = 0
        private set
    var revenue = 0
        private set
    var tagline: String? = null
        private set
    var status: String? = null
        private set

    @Json(name = "release_date")
    var releaseDate: String? = null
        private set

    @Json(name = "poster_path")
    var posterPath: String? = null
        private set

    @Json(name = "original_title")
    var originalTitle: String? = null
        private set

    @Json(name = "original_language")
    var originalLanguage: String? = null
        private set

    @Json(name = "backdrop_path")
    var backdropPath: String? = null
        private set

    @Json(name = "vote_count")
    var voteCount = 0
        private set

    @Json(name = "vote_average")
    var voteAverage = 0f
        private set

    @Json(name = "imdb_id")
    var imdbId: String? = null
        private set
    var paletteColors: PaletteColors? = null
        private set
    var director: String? = null
        private set

    constructor() {}

    fun setAdult(adult: Boolean): MovieDetails {
        isAdult = adult
        return this
    }

    fun setOverview(overview: String?): MovieDetails {
        this.overview = overview
        return this
    }

    fun setVideo(video: Boolean): MovieDetails {
        isVideo = video
        return this
    }

    fun setGenres(genres: List<Genre>?): MovieDetails {
        this.genres = genres
        return this
    }

    fun setTitle(title: String?): MovieDetails {
        this.title = title
        return this
    }

    fun setPopularity(popularity: Float): MovieDetails {
        this.popularity = popularity
        return this
    }

    fun setBudget(budget: Int): MovieDetails {
        this.budget = budget
        return this
    }

    fun setRuntime(runtime: Int): MovieDetails {
        this.runtime = runtime
        return this
    }

    fun setRevenue(revenue: Int): MovieDetails {
        this.revenue = revenue
        return this
    }

    fun setTagline(tagline: String?): MovieDetails {
        this.tagline = tagline
        return this
    }

    fun setStatus(status: String?): MovieDetails {
        this.status = status
        return this
    }

    fun setReleaseDate(releaseDate: String?): MovieDetails {
        this.releaseDate = releaseDate
        return this
    }

    fun setPosterPath(posterPath: String?): MovieDetails {
        this.posterPath = posterPath
        return this
    }

    fun setOriginalTitle(originalTitle: String?): MovieDetails {
        this.originalTitle = originalTitle
        return this
    }

    fun setOriginalLanguage(originalLanguage: String?): MovieDetails {
        this.originalLanguage = originalLanguage
        return this
    }

    fun setBackdropPath(backdropPath: String?): MovieDetails {
        this.backdropPath = backdropPath
        return this
    }

    fun setVoteCount(voteCount: Int): MovieDetails {
        this.voteCount = voteCount
        return this
    }

    fun setVoteAverage(voteAverage: Float): MovieDetails {
        this.voteAverage = voteAverage
        return this
    }

    fun setImdbId(imdbId: String?): MovieDetails {
        this.imdbId = imdbId
        return this
    }

    fun setPaletteColors(paletteColors: PaletteColors?): MovieDetails {
        this.paletteColors = paletteColors
        return this
    }

    fun setDirector(director: String?): MovieDetails {
        this.director = director
        return this
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeByte(if (isAdult) 1.toByte() else 0.toByte())
        dest.writeString(overview)
        dest.writeByte(if (isVideo) 1.toByte() else 0.toByte())
        dest.writeTypedList(genres)
        dest.writeString(title)
        dest.writeFloat(popularity)
        dest.writeInt(budget)
        dest.writeInt(runtime)
        dest.writeInt(revenue)
        dest.writeString(tagline)
        dest.writeString(status)
        dest.writeString(releaseDate)
        dest.writeString(posterPath)
        dest.writeString(originalTitle)
        dest.writeString(originalLanguage)
        dest.writeString(backdropPath)
        dest.writeInt(voteCount)
        dest.writeFloat(voteAverage)
        dest.writeString(imdbId)
        dest.writeParcelable(paletteColors, flags)
        dest.writeString(director)
    }

    protected constructor(`in`: Parcel) {
        isAdult = `in`.readByte().toInt() != 0
        overview = `in`.readString()
        isVideo = `in`.readByte().toInt() != 0
        genres = `in`.createTypedArrayList(Genre.CREATOR)
        title = `in`.readString()
        popularity = `in`.readFloat()
        budget = `in`.readInt()
        runtime = `in`.readInt()
        revenue = `in`.readInt()
        tagline = `in`.readString()
        status = `in`.readString()
        releaseDate = `in`.readString()
        posterPath = `in`.readString()
        originalTitle = `in`.readString()
        originalLanguage = `in`.readString()
        backdropPath = `in`.readString()
        voteCount = `in`.readInt()
        voteAverage = `in`.readFloat()
        imdbId = `in`.readString()
        paletteColors = `in`.readParcelable(PaletteColors::class.java.classLoader)
        director = `in`.readString()
    }

    companion object {
        val CREATOR: Parcelable.Creator<MovieDetails> = object : Parcelable.Creator<MovieDetails> {
            override fun createFromParcel(source: Parcel): MovieDetails? {
                return MovieDetails(source)
            }

            override fun newArray(size: Int): Array<MovieDetails?> {
                return arrayOfNulls(size)
            }
        }
    }
}
