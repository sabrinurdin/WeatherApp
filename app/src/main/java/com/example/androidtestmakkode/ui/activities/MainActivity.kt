package com.example.androidtestmakkode.ui.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.androidtestmakkode.R
import com.example.androidtestmakkode.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("TAGLIFECYCLE","onCreate")

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.findNavController()

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.weatherFragment
            )
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onStart() {
        super.onStart()
        Log.d("TAGLIFECYCLE","onStart")
    }

    override fun onResume() {
        super.onResume()
            Log.d("TAGLIFECYCLE","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("TAGLIFECYCLE","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("TAGLIFECYCLE","onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("TAGLIFECYCLE","onDestroy")
    }

}