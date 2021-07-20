package com.example.marvel.di.modules.ui

import com.example.marvel.ui.screen.characters.CharactersFragment
import com.example.marvel.ui.screen.comics.ComicsFragment
import com.example.marvel.ui.screen.creators.CreatorsFragment
import com.example.marvel.ui.screen.events.EventsFragment
import com.example.marvel.ui.screen.saved.SavedFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    internal abstract fun contributeCharactersFragment(): CharactersFragment

    @ContributesAndroidInjector
    internal abstract fun contributeComicsFragment(): ComicsFragment

    @ContributesAndroidInjector
    internal abstract fun contributeCreatorsFragment(): CreatorsFragment

    @ContributesAndroidInjector
    internal abstract fun contributeEventsFragment(): EventsFragment

    @ContributesAndroidInjector
    internal abstract fun contributeSavedFragment() : SavedFragment


}