package com.example.marvel.ui.screen.main

import android.os.Bundle
import com.example.marvel.R
import com.example.marvel.ui.base.AbsActivity
import com.example.marvel.ui.screen.characters.CharactersFragment

class MainActivity : AbsActivity<MainViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.flMain, CharactersFragment())
            .commit()
    }

    override fun provideLayoutId() = R.layout.activity_main

    override fun provideViewModelClass() = MainViewModel::class

}