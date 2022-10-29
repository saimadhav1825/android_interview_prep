package com.example.prepareinterview

import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.prepareinterview.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    var msg = "MainActivity : "
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
    /** Called when the activity is about to become visible.  */
    override fun onStart() {
        super.onStart()
        Log.d(msg, "The onStart() event")
    }

    /** Called when the activity has become visible.  */
    override fun onResume() {
        super.onResume()
        Log.d(msg, "The onResume() event")
    }

    /** Called when another activity is taking focus.  */
    override fun onPause() {
        super.onPause()
        Log.d(msg, "The onPause() event")
    }

    /** Called when the activity is no longer visible.  */
    override fun onStop() {
        super.onStop()
        Log.d(msg, "The onStop() event")
    }

    /** Called just before the activity is destroyed.  */
    override fun onDestroy() {
        super.onDestroy()
        Log.d(msg, "The onDestroy() event")
    }

    /**called when the activity restarts after stopping it*/
    override fun onRestart() {
        super.onRestart()
        Log.d(msg, "The onRestart() event")
    }
}