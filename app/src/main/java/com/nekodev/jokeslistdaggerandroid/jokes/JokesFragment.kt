package com.nekodev.jokeslistdaggerandroid.jokes

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nekodev.jokeslistdaggerandroid.R
import com.nekodev.jokeslistdaggerandroid.api.JokesService
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class JokesFragment : Fragment() {

    companion object {
        fun newInstance(): JokesFragment {
            return JokesFragment()
        }
    }

    @Inject
    lateinit var service: JokesService

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_jokes, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        injectDependencies()
    }

    private fun injectDependencies() {
        AndroidSupportInjection.inject(this)
    }
}