package com.harshil.daggerhilt

import android.app.Activity
import android.app.Application
import com.harshil.daggerhilt.manual.container.AppContainer
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class InitApp : Application() {

    // For Manual dependency
    // Instance of AppContainer that will be used by all the Activities of the app
    val appContainer = AppContainer()
}

/*
class MyApplication : Application(), HasActivityInjector {
    @Inject
    var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>? = null
    override fun onCreate() {
        super.onCreate()
        DaggerMyApplicationComponent.create().inject(this)
    }

    fun activityInjector(): DispatchingAndroidInjector<Activity>? {
        return dispatchingAndroidInjector
    }
}*/
