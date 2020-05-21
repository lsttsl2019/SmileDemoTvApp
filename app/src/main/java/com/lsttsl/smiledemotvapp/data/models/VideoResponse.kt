package com.lsttsl.smiledemotvapp.data.models

class VideoResponse {
    var id = 0
        private set
    var results: List<Video>? = null
        private set

    fun setId(id: Int): VideoResponse {
        this.id = id
        return this
    }

    fun setResults(results: List<Video>?): VideoResponse {
        this.results = results
        return this
    }
}
