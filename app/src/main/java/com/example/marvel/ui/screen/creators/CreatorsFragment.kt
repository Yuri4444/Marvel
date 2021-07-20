package com.example.marvel.ui.screen.creators

import com.example.marvel.R
import com.example.marvel.ui.base.AbsFragment
import kotlin.reflect.KClass

class CreatorsFragment : AbsFragment<CreatorsViewModel>() {

    override fun provideLayoutId() = R.layout.fragment_creators

    override fun provideViewModelClass(): KClass<CreatorsViewModel> = CreatorsViewModel::class
}