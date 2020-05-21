package com.lsttsl.smiledemotvapp.data.models

import android.os.Parcel
import android.os.Parcelable
import com.squareup.moshi.Json

open class Movie : Parcelable {
    var id: String? = null
        private set

    @Json(name = "poster_path")
    var posterPath: String? = null
        private set
    var isAdult = false
        private set
    var overview: String? = null
        private set

    @Json(name = "release_date")
    var releaseDate: String? = null
        private set

    @Json(name = "genre_ids")
    var genreIds: List<String>? = null
        private set

    @Json(name = "original_title")
    var originalTitle: String? = null
        private set

    @Json(name = "original_language")
    var originalLanguage: String? = null
        private set
    var title: String? = null
        private set

    @Json(name = "backdrop_path")
    var backdropPath: String? = null
        private set
    var popularity = 0f
        private set

    @Json(name = "vote_count")
    var voteCount = 0
        private set
    var isVideo = false
        private set

    @Json(name = "vote_average")
    var voteAverage = 0f
        private set

    constructor() {}

    fun setId(id: String?): Movie {
        this.id = id
        return this
    }

    fun setPosterPath(posterPath: String?): Movie {
        this.posterPath = posterPath
        return this
    }

    fun setAdult(adult: Boolean): Movie {
        isAdult = adult
        return this
    }

    fun setOverview(overview: String?): Movie {
        this.overview = overview
        return this
    }

    fun setReleaseDate(releaseDate: String?): Movie {
        this.releaseDate = releaseDate
        return this
    }

    fun setGenreIds(genreIds: List<String>?): Movie {
        this.genreIds = genreIds
        return this
    }

    fun setOriginalTitle(originalTitle: String?): Movie {
        this.originalTitle = originalTitle
        return this
    }

    fun setOriginalLanguage(originalLanguage: String?): Movie {
        this.originalLanguage = originalLanguage
        return this
    }

    fun setTitle(title: String?): Movie {
        this.title = title
        return this
    }

    fun setBackdropPath(backdropPath: String?): Movie {
        this.backdropPath = backdropPath
        return this
    }

    fun setPopularity(popularity: Float): Movie {
        this.popularity = popularity
        return this
    }

    fun setVoteCount(voteCount: Int): Movie {
        this.voteCount = voteCount
        return this
    }

    fun setVideo(video: Boolean): Movie {
        isVideo = video
        return this
    }

    fun setVoteAverage(voteAverage: Float): Movie {
        this.voteAverage = voteAverage
        return this
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(id)
        dest.writeString(posterPath)
        dest.writeByte(if (isAdult) 1.toByte() else 0.toByte())
        dest.writeString(overview)
        dest.writeString(releaseDate)
        dest.writeStringList(genreIds)
        dest.writeString(originalTitle)
        dest.writeString(originalLanguage)
        dest.writeString(title)
        dest.writeString(backdropPath)
        dest.writeFloat(popularity)
        dest.writeInt(voteCount)
        dest.writeByte(if (isVideo) 1.toByte() else 0.toByte())
        dest.writeFloat(voteAverage)
    }

    protected constructor(`in`: Parcel) {
        id = `in`.readString()
        posterPath = `in`.readString()
        isAdult = `in`.readByte().toInt() != 0
        overview = `in`.readString()
        releaseDate = `in`.readString()
        genreIds = `in`.createStringArrayList()
        originalTitle = `in`.readString()
        originalLanguage = `in`.readString()
        title = `in`.readString()
        backdropPath = `in`.readString()
        popularity = `in`.readFloat()
        voteCount = `in`.readInt()
        isVideo = `in`.readByte().toInt() != 0
        voteAverage = `in`.readFloat()
    }

    companion object {
        val CREATOR: Parcelable.Creator<Movie> = object : Parcelable.Creator<Movie> {
            override fun createFromParcel(source: Parcel): Movie? {
                return Movie(source)
            }

            override fun newArray(size: Int): Array<Movie?> {
                return arrayOfNulls(size)
            }
        }
    }
}
