package com.al.kotlin01helloworld

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // 隐藏 ActionBar
        supportActionBar?.hide()
        // val navController = findNavController(R.id.fragmentContainerView)
        // val buttonNavigation: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        // buttonNavigation.setupWithNavController(navController)
    }

    override fun onStart() {
        super.onStart()

        val navController = findNavController(R.id.fragmentContainerView)
        val buttonNavigation: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        // 自动导航
        // buttonNavigation.setupWithNavController(navController)
        // 手动导航
        buttonNavigation.setOnItemReselectedListener {
            when (it.itemId) {
                R.id.firstFragment2 -> Toast.makeText(this, "firstFragment2", Toast.LENGTH_SHORT)
                    .show()
                R.id.secondFragment2 -> Toast.makeText(this, "secondFragment2", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}