package com.nekodev.jokeslistdaggerandroid.api

import io.reactivex.Single
import javax.inject.Inject


class JokesRepository @Inject constructor(private val service: JokesService) {

    fun getJokes(numOfJokes: Int): Single<Jokes> {
        return service.getJokes(numOfJokes)
    }
}