package com.example.marvel.di.modules

import com.example.marvel.di.modules.ui.ActivityModule
import com.example.marvel.di.modules.ui.FragmentModule
import com.example.marvel.di.modules.ui.ViewModelModule
import dagger.Module

@Module(
    includes = [
        ActivityModule::class,
        FragmentModule::class,
        ViewModelModule::class
    ]
)
class UiModule