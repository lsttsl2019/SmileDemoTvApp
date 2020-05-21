package com.lsttsl.smiledemotvapp.dagger.components

import com.lsttsl.smiledemotvapp.App
import com.lsttsl.smiledemotvapp.dagger.AppScope
import com.lsttsl.smiledemotvapp.dagger.modules.ApplicationModule
import com.lsttsl.smiledemotvapp.dagger.modules.HttpClientModule
import com.lsttsl.smiledemotvapp.ui.main.MainFragment
import dagger.Component
import javax.inject.Singleton

@AppScope
@Singleton
@Component(modules = [ApplicationModule::class, HttpClientModule::class])
interface ApplicationComponent {
    fun inject(app: App)
    fun inject(mainFragment: MainFragment?)
}
