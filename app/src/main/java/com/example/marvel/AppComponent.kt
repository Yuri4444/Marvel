package com.example.marvel

import com.example.marvel.di.modules.data.NetworkModule
import com.example.marvel.di.modules.ui.ActivityModule
import com.example.marvel.di.modules.ui.FragmentModule
import com.example.marvel.di.modules.ui.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ActivityModule::class,
    FragmentModule::class,
    ViewModelModule::class,
    NetworkModule::class,
    AndroidInjectionModule::class
])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: AppApplication) : Builder

        fun build() : AppComponent
    }

    fun inject(application: AppApplication)
}