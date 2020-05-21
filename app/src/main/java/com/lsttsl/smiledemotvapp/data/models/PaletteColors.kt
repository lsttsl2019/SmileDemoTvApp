package com.lsttsl.smiledemotvapp.data.models

import android.os.Parcel
import android.os.Parcelable


class PaletteColors : Parcelable {
    var toolbarBackgroundColor = 0
        private set
    var statusBarColor = 0
        private set
    var textColor = 0
        private set
    var titleColor = 0
        private set

    constructor() {}

    fun setToolbarBackgroundColor(toolbarBackgroundColor: Int): PaletteColors {
        this.toolbarBackgroundColor = toolbarBackgroundColor
        return this
    }

    fun setStatusBarColor(statusBarColor: Int): PaletteColors {
        this.statusBarColor = statusBarColor
        return this
    }

    fun setTextColor(textColor: Int): PaletteColors {
        this.textColor = textColor
        return this
    }

    fun setTitleColor(titleColor: Int): PaletteColors {
        this.titleColor = titleColor
        return this
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(toolbarBackgroundColor)
        dest.writeInt(statusBarColor)
        dest.writeInt(textColor)
        dest.writeInt(titleColor)
    }

    protected constructor(`in`: Parcel) {
        toolbarBackgroundColor = `in`.readInt()
        statusBarColor = `in`.readInt()
        textColor = `in`.readInt()
        titleColor = `in`.readInt()
    }

    companion object {
        val CREATOR: Parcelable.Creator<PaletteColors> =
            object : Parcelable.Creator<PaletteColors> {
                override fun createFromParcel(source: Parcel): PaletteColors? {
                    return PaletteColors(source)
                }

                override fun newArray(size: Int): Array<PaletteColors?> {
                    return arrayOfNulls(size)
                }
            }
    }
}
