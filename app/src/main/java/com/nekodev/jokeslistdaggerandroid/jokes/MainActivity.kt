package com.nekodev.jokeslistdaggerandroid.jokes

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.nekodev.jokeslistdaggerandroid.R
import dagger.android.AndroidInjection

class MainActivity : AppCompatActivity() {

    companion object {
        private const val JOKES_FRAGMENT_TAG = "jokesFragment"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        configureDagger()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .add(R.id.containerLayout, JokesFragment.newInstance(), JOKES_FRAGMENT_TAG)
                    .commit()
        }
    }

    private fun configureDagger() {
        AndroidInjection.inject(this)
    }
}
