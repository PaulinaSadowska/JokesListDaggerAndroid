package com.nekodev.jokeslistdaggerandroid.jokes

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.nekodev.jokeslistdaggerandroid.R
import com.nekodev.jokeslistdaggerandroid.api.Joke
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class JokesFragment : Fragment() {

    companion object {
        fun newInstance(): JokesFragment {
            return JokesFragment()
        }
    }

    @Inject
    lateinit var viewModel: JokesViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_jokes, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        injectDependencies()
        viewModel.subscribe()
        viewModel.jokes.observe(this, Observer<List<Joke>> { jokes -> processResponse(jokes) })
    }

    private fun processResponse(response: List<Joke>?) {
        response?.let {
            Toast.makeText(context, "jokes " + response.size, Toast.LENGTH_SHORT).show()

            if (response.isNotEmpty()) {
                Toast.makeText(context, response.first().joke, Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun injectDependencies() {
        AndroidSupportInjection.inject(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.unsubscribe()
    }
}