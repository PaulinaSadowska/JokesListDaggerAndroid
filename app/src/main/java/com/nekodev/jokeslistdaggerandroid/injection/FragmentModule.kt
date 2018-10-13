package com.nekodev.jokeslistdaggerandroid.injection

import com.nekodev.jokeslistdaggerandroid.jokes.JokesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface FragmentModule {
    @ContributesAndroidInjector
    fun contributeJokesFragment(): JokesFragment
}