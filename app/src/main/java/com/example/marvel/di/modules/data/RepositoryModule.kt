package com.example.marvel.di.modules.data

import com.example.marvel.data.network.Api
import com.example.marvel.data.repository.CharactersRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideCharactersRepository(api : Api) = CharactersRepository(api)

}