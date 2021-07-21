package com.example.marvel.di.modules.data

import com.example.marvel.data.db.SearchedNamesDatabase
import com.example.marvel.data.network.Api
import com.example.marvel.data.repository.LocalRepository
import com.example.marvel.data.repository.NetRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideCharactersRepository(api: Api) = NetRepository(api)

    @Singleton
    @Provides
    fun provideLocalRepository(searchedNamesDatabase: SearchedNamesDatabase) =
        LocalRepository(searchedNamesDatabase)

}