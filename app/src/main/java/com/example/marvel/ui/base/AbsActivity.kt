package com.example.marvel.ui.base

import android.content.Context
import android.os.Bundle
import androidx.lifecycle.ViewModel
import com.example.marvel.AppApplication

abstract class AbsActivity<VM : ViewModel> : AbsDaggerActivity<VM>()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(provideLayoutId())
    }


    abstract fun provideLayoutId() : Int

}