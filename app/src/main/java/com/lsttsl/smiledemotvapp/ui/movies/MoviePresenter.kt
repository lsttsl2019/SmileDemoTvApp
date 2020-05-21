package com.lsttsl.smiledemotvapp.ui.movies

import android.view.ViewGroup
import androidx.leanback.widget.Presenter
import com.lsttsl.smiledemotvapp.data.models.Movie

class MoviePresenter() : Presenter() {

    init {

    }

    override fun onCreateViewHolder(parent: ViewGroup?): ViewHolder {
            return ViewHolder(MovieCardView(parent!!.context))
    }

    override fun onBindViewHolder(viewHolder: ViewHolder?, item: Any?) {
        (viewHolder!!.view as MovieCardView).bind(item as Movie?)
    }

    override fun onUnbindViewHolder(viewHolder: ViewHolder?) {

    }


}