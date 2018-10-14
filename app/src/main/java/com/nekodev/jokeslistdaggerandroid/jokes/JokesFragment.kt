package com.nekodev.jokeslistdaggerandroid.jokes

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nekodev.jokeslistdaggerandroid.R
import com.nekodev.jokeslistdaggerandroid.api.Joke
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_jokes.*
import javax.inject.Inject
import android.support.v7.widget.DividerItemDecoration



class JokesFragment : Fragment() {

    companion object {
        fun newInstance(): JokesFragment {
            return JokesFragment()
        }
    }

    @Inject
    lateinit var viewModel: JokesViewModel

    private val jokesAdapter = JokesAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_jokes, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        injectDependencies()
        initializeRecyclerView()
        viewModel.subscribe()
        viewModel.jokes.observe(this, Observer<List<Joke>> { jokes -> processResponse(jokes) })
    }

    private fun initializeRecyclerView() {
        recyclerViewJokes.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = jokesAdapter
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }
    }

    private fun processResponse(response: List<Joke>?) {
        response?.let {
            jokesAdapter.jokes = response
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