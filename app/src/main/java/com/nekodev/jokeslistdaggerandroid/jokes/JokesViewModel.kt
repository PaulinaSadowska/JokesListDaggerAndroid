package com.nekodev.jokeslistdaggerandroid.jokes

import android.arch.lifecycle.MutableLiveData
import com.nekodev.jokeslistdaggerandroid.BaseSchedulerProvider
import com.nekodev.jokeslistdaggerandroid.api.Joke
import com.nekodev.jokeslistdaggerandroid.api.Jokes
import com.nekodev.jokeslistdaggerandroid.api.JokesRepository
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class JokesViewModel @Inject constructor(private val jokesRepository: JokesRepository,
                     private val schedulerProvider: BaseSchedulerProvider) : JokesContract.ViewModel {

    private val disposable = CompositeDisposable()
    val jokes = MutableLiveData<List<Joke>>()

    init {
        jokes.value = emptyList()
    }

    override fun subscribe() {
        disposable.add(jokesRepository.getJokes(20)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribeBy(
                        onSuccess = { onSuccess(it) },
                        onError = { onError() }
                ))
    }

    private fun onSuccess(fetchedJokes: Jokes) {
        jokes.value = fetchedJokes.value
    }

    private fun onError() {
        jokes.value = emptyList()
    }

    override fun unsubscribe() {
        disposable.clear()
    }
}