package com.udacity.shoestore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    // Setup the nav controller with the toolbar and an AppBarConfiguration
//    val navController = findNavController(R.id.nav_host_fragment)
//    val appBarConfiguration = AppBarConfiguration(navController.graph)
//    NavigationUI.setupActionBarWithNavController(this@MainActivity, navController, appBarConfiguration)

    Timber.plant(Timber.DebugTree())
  }
}
