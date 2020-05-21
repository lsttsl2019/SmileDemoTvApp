package com.lsttsl.smiledemotvapp

import android.app.Application
import com.lsttsl.smiledemotvapp.dagger.components.ApplicationComponent
import com.lsttsl.smiledemotvapp.dagger.components.DaggerApplicationComponent
import com.lsttsl.smiledemotvapp.dagger.modules.ApplicationModule
import com.lsttsl.smiledemotvapp.dagger.modules.HttpClientModule
import timber.log.Timber

class App : Application() {
    private var mApplicationComponent: ApplicationComponent? = null
    override fun onCreate() {
        super.onCreate()
        instance = this
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        // Creates Dagger Graph
        mApplicationComponent = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .httpClientModule(HttpClientModule())
            .build()
        mApplicationComponent!!.inject(this)
    }

    fun appComponent(): ApplicationComponent? {
        return mApplicationComponent
    }

    companion object {
        private var instance: App? = null
        fun instance(): App? {
            return instance
        }
    }
}
