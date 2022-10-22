package com.android.app.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.android.app.R
import com.android.app.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val bottomNavigationMenu = findViewById<BottomNavigationView>(R.id.nav_bar)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController

//        val appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.homeFragment,
//                R.id.hiddenTasksFragment,
//                R.id.hotListFragment,
//                R.id.loginFragment,
//                R.id.notesFragment,
//                R.id.registrationFragment,
//                R.id.tasksFragment
//            )
//        )
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.loginFragment -> bottomNavigationMenu.visibility = View.INVISIBLE
                R.id.registrationFragment -> bottomNavigationMenu.visibility = View.INVISIBLE
                else ->  bottomNavigationMenu.visibility = View.VISIBLE
            }
        }
//        setupActionBarWithNavController(navController, appBarConfiguration)

        bottomNavigationMenu.setupWithNavController(navController)
    }
}