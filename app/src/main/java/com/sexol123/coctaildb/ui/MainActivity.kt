package com.sexol123.coctaildb.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.sexol123.coctaildb.R
import com.sexol123.coctaildb.ui.listdrinks.CocktailListFragment
import com.sexol123.coctaildb.ui.listdrinks.CocktailListViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: CocktailListViewModel

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(CocktailListViewModel::class.java)

        val currentFragment: Fragment? = supportFragmentManager.findFragmentById(R.id.fragment_container)
        if (currentFragment == null) {
            replaceFragment(CocktailListFragment())
        }
    }
}