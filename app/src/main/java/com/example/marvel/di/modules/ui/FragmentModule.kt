package com.example.marvel.di.modules.ui

import com.example.marvel.ui.screen.characters.CharactersFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    internal abstract fun contributeCharactersFragment() : CharactersFragment
}