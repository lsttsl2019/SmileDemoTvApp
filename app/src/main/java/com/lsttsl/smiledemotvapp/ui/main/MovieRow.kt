package com.lsttsl.smiledemotvapp.ui.main

import androidx.leanback.widget.ArrayObjectAdapter


class MovieRow {

    private var page: Int? =null
    private var id : Int? =null
    private var adapter: ArrayObjectAdapter? = null
    private var title: String? = null

    fun MovieRow() {}

    fun getPage(): Int {
        return page!!
    }

    fun setPage(page: Int): MovieRow? {
        this.page = page
        return this
    }

    fun getId(): Int {
        return id!!
    }

    fun setId(id: Int): MovieRow? {
        this.id = id
        return this
    }

    fun getAdapter(): ArrayObjectAdapter? {
        return adapter
    }

    fun setAdapter(adapter: ArrayObjectAdapter?): MovieRow? {
        this.adapter = adapter
        return this
    }

    fun getTitle(): String? {
        return title
    }

    fun setTitle(title: String?): MovieRow? {
        this.title = title
        return this
    }


}