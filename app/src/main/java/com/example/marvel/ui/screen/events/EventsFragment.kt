package com.example.marvel.ui.screen.events

import com.example.marvel.R
import com.example.marvel.ui.base.AbsFragment
import kotlin.reflect.KClass

class EventsFragment : AbsFragment<EventsViewModel>() {

    override fun provideLayoutId(): Int = R.layout.fragment_events

    override fun provideViewModelClass(): KClass<EventsViewModel> = EventsViewModel::class
}