package com.example.marvel.ui.screen.comics

import com.example.marvel.R
import com.example.marvel.ui.base.AbsFragment
import kotlin.reflect.KClass

class ComicsFragment : AbsFragment<ComicsViewModel>() {

    override fun provideLayoutId() = R.layout.fragment_comics

    override fun provideViewModelClass(): KClass<ComicsViewModel> = ComicsViewModel::class
}