package com.nekodev.jokeslistdaggerandroid.base

import android.os.Bundle

//todo - remove???
interface BaseContract {

    interface View

    interface ViewModel<in T : View> {
        //fun onStateRestored(savedInstanceState: Bundle)
        fun subscribe()
        //fun onSaveInstanceState(savedInstanceState: Bundle)
        fun unsubscribe()
    }
}
