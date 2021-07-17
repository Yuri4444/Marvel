package com.example.marvel.ui.screen.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.marvel.R
import com.example.marvel.ui.base.AbsActivity
import kotlin.reflect.KClass

class MainActivity : AbsActivity<MainViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun provideLayoutId() = R.layout.activity_main

    override fun provideViewModelClass() =  MainViewModel::class

}