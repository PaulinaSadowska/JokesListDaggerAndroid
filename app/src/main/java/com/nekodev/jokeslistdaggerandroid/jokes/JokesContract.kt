package com.nekodev.jokeslistdaggerandroid.jokes

import com.nekodev.jokeslistdaggerandroid.base.BaseContract

interface JokesContract {
    interface View : BaseContract.View {

    }

    interface ViewModel : BaseContract.ViewModel<View> {

    }
}