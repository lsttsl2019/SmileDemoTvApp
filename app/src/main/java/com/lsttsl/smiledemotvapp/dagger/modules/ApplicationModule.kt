package com.lsttsl.smiledemotvapp.dagger.modules

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(var mApplication: Application) {
    @Singleton
    @Provides
    fun providesApplication(): Application {
        return mApplication
    }

}
