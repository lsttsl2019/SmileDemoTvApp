package com.lsttsl.smiledemotvapp.data.models

import android.os.Parcel
import android.os.Parcelable
import com.squareup.moshi.Json


class CrewMember : Parcelable{
    private var id = 0
    private var job: String? = null
    private var name: String? = null
    private var department: String? = null

    @Json(name = "profile_path")
    private var profilePath: String? = null


    constructor(){}


    fun getId(): Int {
        return id
    }

    fun setId(id: Int): CrewMember? {
        this.id = id
        return this
    }

    fun getJob(): String? {
        return job
    }

    fun setJob(job: String?): CrewMember? {
        this.job = job
        return this
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String?): CrewMember? {
        this.name = name
        return this
    }

    fun getDepartment(): String? {
        return department
    }

    fun setDepartment(department: String?): CrewMember? {
        this.department = department
        return this
    }

    fun getProfilePath(): String? {
        return profilePath
    }

    fun setProfilePath(profilePath: String?): CrewMember? {
        this.profilePath = profilePath
        return this
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(id)
        dest.writeString(job)
        dest.writeString(name)
        dest.writeString(department)
        dest.writeString(profilePath)
    }


    constructor(parcel : Parcel){
        id = parcel.readInt()
        job = parcel.readString()
        name = parcel.readString()
        department = parcel.readString()
        profilePath = parcel.readString()
    }

    val CREATOR: Parcelable.Creator<CrewMember> = object : Parcelable.Creator<CrewMember> {
        override fun createFromParcel(source: Parcel): CrewMember? {
            return CrewMember(source)
        }

        override fun newArray(size: Int): Array<CrewMember?> {
            return arrayOfNulls(size)
        }
    }


}