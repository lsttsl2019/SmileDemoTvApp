package com.lsttsl.smiledemotvapp.data.models

import android.os.Parcel
import android.os.Parcelable
import com.squareup.moshi.Json

class Person : Parcelable {
    var id = 0
        private set
    var biography: String? = null
        private set
    var birthday: String? = null
        private set
    var deathday: String? = null
        private set
    var gender = 0
        private set
    var homepage: String? = null
        private set
    var name: String? = null
        private set
    var popularity = 0f
        private set
    var isAdult = false
        private set

    @Json(name = "profile_path")
    var profilePath: String? = null
        private set

    @Json(name = "place_of_birth")
    var placeOfBirth: String? = null
        private set

    constructor() {}

    fun setId(id: Int): Person {
        this.id = id
        return this
    }

    fun setBiography(biography: String?): Person {
        this.biography = biography
        return this
    }

    fun setBirthday(birthday: String?): Person {
        this.birthday = birthday
        return this
    }

    fun setDeathday(deathday: String?): Person {
        this.deathday = deathday
        return this
    }

    fun setGender(gender: Int): Person {
        this.gender = gender
        return this
    }

    fun setHomepage(homepage: String?): Person {
        this.homepage = homepage
        return this
    }

    fun setName(name: String?): Person {
        this.name = name
        return this
    }

    fun setPopularity(popularity: Float): Person {
        this.popularity = popularity
        return this
    }

    fun setAdult(adult: Boolean): Person {
        isAdult = adult
        return this
    }

    fun setProfilePath(profilePath: String?): Person {
        this.profilePath = profilePath
        return this
    }

    fun setPlaceOfBirth(placeOfBirth: String?): Person {
        this.placeOfBirth = placeOfBirth
        return this
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(id)
        dest.writeString(biography)
        dest.writeString(birthday)
        dest.writeString(deathday)
        dest.writeInt(gender)
        dest.writeString(homepage)
        dest.writeString(name)
        dest.writeFloat(popularity)
        dest.writeByte(if (isAdult) 1.toByte() else 0.toByte())
        dest.writeString(profilePath)
        dest.writeString(placeOfBirth)
    }

    protected constructor(`in`: Parcel) {
        id = `in`.readInt()
        biography = `in`.readString()
        birthday = `in`.readString()
        deathday = `in`.readString()
        gender = `in`.readInt()
        homepage = `in`.readString()
        name = `in`.readString()
        popularity = `in`.readFloat()
        isAdult = `in`.readByte().toInt() != 0
        profilePath = `in`.readString()
        placeOfBirth = `in`.readString()
    }

    companion object {
        val CREATOR: Parcelable.Creator<Person> = object : Parcelable.Creator<Person> {
            override fun createFromParcel(source: Parcel): Person? {
                return Person(source)
            }

            override fun newArray(size: Int): Array<Person?> {
                return arrayOfNulls(size)
            }
        }
    }
}
