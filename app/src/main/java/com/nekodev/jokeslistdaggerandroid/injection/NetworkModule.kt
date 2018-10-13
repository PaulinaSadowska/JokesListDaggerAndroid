package com.nekodev.jokeslistdaggerandroid.injection

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.nekodev.jokeslistdaggerandroid.api.JokesService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideJokesService(retrofit: Retrofit): JokesService {
        return retrofit.create<JokesService>(JokesService::class.java)
    }

    @Provides
    fun provideRetrofit(gson: Gson): Retrofit {
        return Retrofit.Builder()
                .baseUrl("http://api.icndb.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
    }

    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }
}