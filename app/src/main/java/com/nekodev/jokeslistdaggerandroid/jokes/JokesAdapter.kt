package com.nekodev.jokeslistdaggerandroid.jokes

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nekodev.jokeslistdaggerandroid.R
import com.nekodev.jokeslistdaggerandroid.api.Joke
import kotlinx.android.synthetic.main.item_joke.view.*

class JokesAdapter : RecyclerView.Adapter<JokesAdapter.ViewHolder>() {

    var jokes: List<Joke> = emptyList()
        set(jokes) {
            field = jokes
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, type: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_joke, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount() = jokes.size

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(jokes[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val textJoke = itemView.textJoke

        fun bind(joke: Joke) {
            textJoke.text = joke.joke
        }
    }
}