package com.nekodev.jokeslistdaggerandroid.injection

import android.app.Application
import com.nekodev.jokeslistdaggerandroid.JokesApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [ActivityModule::class, AndroidSupportInjectionModule::class])
interface AppComponent {

    fun inject(app: JokesApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}