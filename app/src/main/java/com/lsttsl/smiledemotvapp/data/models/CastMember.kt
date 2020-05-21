package com.lsttsl.smiledemotvapp.data.models

import android.os.Parcel
import android.os.Parcelable
import com.squareup.moshi.Json


class CastMember : Parcelable{

    private var id = 0
    private var character: String? = null
    private var name: String? = null
    private var order = 0

    @Json(name = "cast_id")
    private var castId = 0

    @Json(name = "credit_id")
    private var creditId: String? = null

    @Json(name = "profile_path")
    private var profilePath: String? = null

    fun CastMember() {}

    fun getId(): Int {
        return id
    }

    fun setId(id: Int): CastMember? {
        this.id = id
        return this
    }

    fun getCastId(): Int {
        return castId
    }

    fun setCastId(castId: Int): CastMember? {
        this.castId = castId
        return this
    }

    fun getCharacter(): String? {
        return character
    }

    fun setCharacter(character: String?): CastMember? {
        this.character = character
        return this
    }

    fun getCreditId(): String? {
        return creditId
    }

    fun setCreditId(creditId: String?): CastMember? {
        this.creditId = creditId
        return this
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String?): CastMember? {
        this.name = name
        return this
    }

    fun getOrder(): Int {
        return order
    }

    fun setOrder(order: Int): CastMember? {
        this.order = order
        return this
    }

    fun getProfilePath(): String? {
        return profilePath
    }

    fun setProfilePath(profilePath: String?): CastMember? {
        this.profilePath = profilePath
        return this
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(id)
        dest.writeString(character)
        dest.writeString(name)
        dest.writeInt(order)
        dest.writeInt(castId)
        dest.writeString(creditId)
        dest.writeString(profilePath)
    }

    protected fun CastMember( parcel: Parcel): CastMember? {
        id =  parcel.readInt()
        character =  parcel.readString()
        name =  parcel.readString()
        order =  parcel.readInt()
        castId =  parcel.readInt()
        creditId =  parcel.readString()
        profilePath =  parcel.readString()
        return  this
    }

    val CREATOR: Parcelable.Creator<CastMember?> = object : Parcelable.Creator<CastMember?> {
        override fun createFromParcel(source: Parcel): CastMember? {
            return CastMember(source)
        }

        override fun newArray(size: Int): Array<CastMember?> {
            return arrayOfNulls(size)
        }
    }

}


