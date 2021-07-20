package com.example.marvel.di.modules.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.marvel.di.ViewModelFactory
import com.example.marvel.di.ViewModelKey
import com.example.marvel.ui.screen.characters.CharactersViewModel
import com.example.marvel.ui.screen.comics.ComicsViewModel
import com.example.marvel.ui.screen.creators.CreatorsViewModel
import com.example.marvel.ui.screen.events.EventsViewModel
import com.example.marvel.ui.screen.main.MainViewModel
import com.example.marvel.ui.screen.saved.SavedViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun provideViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun provideMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CharactersViewModel::class)
    abstract fun provideCharactersViewModel(viewModel: CharactersViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ComicsViewModel::class)
    abstract fun provideComicsViewModel(viewModel: ComicsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CreatorsViewModel::class)
    abstract fun provideCreatorsViewModel(viewModel: CreatorsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(EventsViewModel::class)
    abstract fun provideEventsViewModel(viewModel: EventsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SavedViewModel::class)
    abstract fun provideSavedViewModel(viewModel: SavedViewModel): ViewModel
}