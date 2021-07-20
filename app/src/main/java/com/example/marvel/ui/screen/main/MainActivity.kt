package com.example.marvel.ui.screen.main

import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.marvel.R
import com.example.marvel.ui.base.AbsActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AbsActivity<MainViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        provideBottomNavigation()

    }

    private fun provideBottomNavigation() {

        val navController = findNavController(R.id.fragmentContainerView)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.charactersFragment,
                R.id.comicsFragment,
                R.id.creatorsFragment,
                R.id.eventsFragment,
                R.id.savedFragment
            )
        )
        bottomNavigation.setupWithNavController(navController)
        setupActionBarWithNavController(navController, appBarConfiguration)

    }

    override fun provideLayoutId() = R.layout.activity_main

    override fun provideViewModelClass() = MainViewModel::class

}