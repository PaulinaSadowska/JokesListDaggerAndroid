package com.nekodev.jokeslistdaggerandroid.injection

import com.nekodev.jokeslistdaggerandroid.jokes.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityModule {
    @ContributesAndroidInjector(modules = [FragmentModule::class])
    fun contributeMainActivity(): MainActivity
}