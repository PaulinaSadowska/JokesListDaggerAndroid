package com.nekodev.jokeslistdaggerandroid.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path


interface JokesService {

    //http://api.icndb.com/jokes/random/20
    @GET("jokes/random/{numOfJokes}")
    fun getJokes(@Path("numOfJokes") numOfJokes: Int): Single<Jokes>
}

data class Joke(val id: Int,
                val joke: String)

data class Jokes(val value: List<Joke>)