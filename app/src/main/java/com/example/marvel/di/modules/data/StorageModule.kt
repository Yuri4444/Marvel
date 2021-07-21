package com.example.marvel.di.modules.data


import android.content.Context
import androidx.room.Room
import com.example.marvel.data.db.SearchedNamesDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class StorageModule {

    @Singleton
    @Provides
    fun provideSearchedNamesDatabase(context: Context): SearchedNamesDatabase =
        Room.databaseBuilder(
            context.applicationContext,
            SearchedNamesDatabase::class.java,
            SearchedNamesDatabase.DATABASE_NAME
        ).fallbackToDestructiveMigration()
            .build()

}