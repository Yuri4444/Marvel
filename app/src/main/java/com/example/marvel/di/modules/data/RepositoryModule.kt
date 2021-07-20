package com.example.marvel.di.modules.data

import com.example.marvel.data.network.Api
import com.example.marvel.data.repository.Repository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideCharactersRepository(api : Api) = Repository(api)

}