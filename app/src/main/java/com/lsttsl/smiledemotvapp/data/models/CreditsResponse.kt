package com.lsttsl.smiledemotvapp.data.models

class CreditsResponse{
    private var id = 0
    private var cast: List<CastMember?>? = null
    private var crew: List<CrewMember?>? = null

    fun CreditsResponse() {}

    fun getId(): Int {
        return id
    }

    fun setId(id: Int): CreditsResponse? {
        this.id = id
        return this
    }

    fun getCast(): List<CastMember?>? {
        return cast
    }

    fun setCast(cast: List<CastMember?>?): CreditsResponse? {
        this.cast = cast
        return this
    }

    fun getCrew(): List<CrewMember?>? {
        return crew
    }

    fun setCrew(crew: List<CrewMember?>?): CreditsResponse? {
        this.crew = crew
        return this
    }

}