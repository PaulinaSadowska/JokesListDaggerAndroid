package com.nekodev.jokeslistdaggerandroid.injection

import com.nekodev.jokeslistdaggerandroid.BaseSchedulerProvider
import com.nekodev.jokeslistdaggerandroid.SchedulerProvider
import dagger.Binds
import dagger.Module

@Module
interface SchedulerModule {
    @Binds
    fun provideSchedulerProvider(schedulerProvider: SchedulerProvider): BaseSchedulerProvider
}