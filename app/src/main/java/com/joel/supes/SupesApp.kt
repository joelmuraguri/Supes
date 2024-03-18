package com.joel.supes

import android.app.Application
import com.joel.supes.di.AppContainer
import com.joel.supes.di.DefaultAppContainer
import timber.log.Timber

class SupesApp : Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        plantDebugBuildLogger()
        container = DefaultAppContainer()
    }

    private fun plantDebugBuildLogger() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}