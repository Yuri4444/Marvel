package com.example.marvel.di.modules

import com.example.marvel.di.modules.data.NetworkModule
import com.example.marvel.di.modules.data.RepositoryModule
import dagger.Module

@Module(
    includes = [
        NetworkModule::class,
        RepositoryModule::class
    ]
)
class DataModule