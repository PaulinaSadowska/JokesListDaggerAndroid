package com.nekodev.jokeslistdaggerandroid.jokes

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.nekodev.jokeslistdaggerandroid.R
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasSupportFragmentInjector {

    companion object {
        private const val JOKES_FRAGMENT_TAG = "jokesFragment"
    }

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        injectDependencies()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .add(R.id.containerLayout, JokesFragment.newInstance(), JOKES_FRAGMENT_TAG)
                    .commit()
        }
    }

    private fun injectDependencies() {
        AndroidInjection.inject(this)
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return dispatchingAndroidInjector
    }
}
