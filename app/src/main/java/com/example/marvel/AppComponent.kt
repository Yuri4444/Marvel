package com.example.marvel

import com.example.marvel.di.modules.DataModule
import com.example.marvel.di.modules.UiModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        UiModule::class,
        DataModule::class,
        AndroidInjectionModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: AppApplication): Builder

        fun build(): AppComponent
    }

    fun inject(application: AppApplication)
}