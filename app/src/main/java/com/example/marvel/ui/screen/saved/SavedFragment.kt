package com.example.marvel.ui.screen.saved

import com.example.marvel.R
import com.example.marvel.ui.base.AbsFragment
import kotlin.reflect.KClass

class SavedFragment : AbsFragment<SavedViewModel>() {

    override fun provideLayoutId(): Int = R.layout.fragment_saved

    override fun provideViewModelClass(): KClass<SavedViewModel> = SavedViewModel::class
}