package com.oruel.testmydoc

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.oruel.testmydoc.repository.network.NetworkModule

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
//        val call = navView.findViewById<View>(R.id.navigation_call_doctor)
//        call.setOnClickListener {
//            val intent = Intent(Intent.ACTION_CALL,Uri.parse("+375256180625"))
//            startActivity(intent)
//        }



        val navController = findNavController(R.id.nav_host_fragment)
        navController.currentDestination
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_order_ticket, R.id.navigation_personal_area))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
            // NetworkModule().getRoom(40)
    }

}