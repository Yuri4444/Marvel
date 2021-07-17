package com.example.marvel

import android.app.Application
import android.content.Context
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class AppApplication : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .application(this)
            .build().apply {
                inject(this@AppApplication)
            }
    }

    override fun androidInjector() = androidInjector

    companion object {

        fun getApp(context: Context?): Context? {
            val appContext = context?.applicationContext
            return if (appContext is Context) appContext else null
        }

    }

}