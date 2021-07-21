package com.example.marvel.di.modules

import android.content.Context
import com.example.marvel.AppApplication
import com.example.marvel.di.modules.data.NetworkModule
import com.example.marvel.di.modules.data.RepositoryModule
import com.example.marvel.di.modules.data.StorageModule
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(
    includes = [
        NetworkModule::class,
        RepositoryModule::class,
        StorageModule::class
    ]
)
class DataModule {

    @Singleton
    @Provides
    fun provideContext(application: AppApplication): Context =
        application.applicationContext

}