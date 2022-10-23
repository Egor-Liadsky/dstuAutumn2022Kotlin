package com.android.app.activities

import android.content.res.Configuration
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.android.app.Constants
import com.android.app.R
import com.android.app.data.preferences.PreferencesStore
import com.android.app.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val toolbarMain = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbarMain)
        toolbarMain.inflateMenu(R.menu.toolbar_menu)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        val bottomNavigationMenu = findViewById<BottomNavigationView>(R.id.nav_bar)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.hiddenTasksFragment,
                R.id.hotListFragment,
                R.id.loginFragment,
                R.id.notesFragment,
                R.id.registrationFragment,
                R.id.tasksFragment,
                R.id.settingsFragment
            )
        )
        if (PreferencesStore(applicationContext).setSavedTheme()) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.loginFragment -> bottomNavigationMenu.visibility = View.INVISIBLE
                R.id.registrationFragment -> bottomNavigationMenu.visibility = View.INVISIBLE
                else -> bottomNavigationMenu.visibility = View.VISIBLE
            }
        }
        setupActionBarWithNavController(navController, appBarConfiguration)

        bottomNavigationMenu.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val currentTheme = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        when (resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) {
            Configuration.UI_MODE_NIGHT_YES -> {
                Constants.THEME = "ТЕМНАЯ"
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                savedTheme(true)
            }
            Configuration.UI_MODE_NIGHT_NO -> {
                Constants.THEME = "СВЕТЛАЯ"
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                savedTheme(false)
            }
        }
        return true
    }

    private fun savedTheme(themeSelect: Boolean) {
        PreferencesStore(this).saveTheme(themeSelect)
    }

    private fun setTheme() {
        if (PreferencesStore(this).setSavedTheme()) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
    }
}