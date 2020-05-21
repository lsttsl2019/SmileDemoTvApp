package com.lsttsl.smiledemotvapp.ui.main

import android.annotation.SuppressLint
import android.os.Bundle
import com.lsttsl.smiledemotvapp.ui.base.BaseTvActivity

@SuppressLint("Registered")
class MainActivity  : BaseTvActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addFragment(MainFragment.newInstance())
    }

}