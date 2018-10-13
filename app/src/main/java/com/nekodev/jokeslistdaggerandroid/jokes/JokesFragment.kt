package com.nekodev.jokeslistdaggerandroid.jokes

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nekodev.jokeslistdaggerandroid.R

class JokesFragment : Fragment() {

    companion object {
        fun newInstance(): JokesFragment {
            return JokesFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_jokes, container, false)
    }
}