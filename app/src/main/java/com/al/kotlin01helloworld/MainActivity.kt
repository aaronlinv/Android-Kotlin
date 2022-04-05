package com.al.kotlin01helloworld

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // 隐藏 ActionBar
        // supportActionBar?.hide()
    }

    override fun onStart() {
        super.onStart()
        // onStart(): Activity 中获取，需要 Fragment 装载完毕才可以
        navController = findNavController(R.id.fragmentContainerView)

        // navController 与 ActionBar 绑定
        setupActionBarWithNavController(navController)
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            val info = "导航到了 ${destination.label}"
            Toast.makeText(this, info, Toast.LENGTH_SHORT).show()
        }
    }

    // 返回按钮具体功能
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}