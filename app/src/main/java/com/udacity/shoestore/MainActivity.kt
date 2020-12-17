package com.udacity.shoestore

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding
  private lateinit var navController: NavController

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

    // In MainActivity, setup the nav controller with the toolbar and an AppBarConfiguration.
    navController = NavController(this)
//    NavigationUI.setupActionBarWithNavController(this, navController)

    Timber.plant(Timber.DebugTree())
  }

  // Add Log out menu
  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    menuInflater.inflate(R.menu.overflow_menu, menu)
    return true
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    return NavigationUI.onNavDestinationSelected(item, navController)
            || super.onOptionsItemSelected(item)
  }
}
