package com.example.marvel.ui.screen.characters

import com.example.marvel.R
import com.example.marvel.ui.base.AbsFragment
import kotlin.reflect.KClass

class CharactersFragment : AbsFragment<CharactersViewModel>() {


    override fun provideLayoutId() = R.layout.fragment_characters

    override fun provideViewModelClass(): KClass<CharactersViewModel> = CharactersViewModel::class
}