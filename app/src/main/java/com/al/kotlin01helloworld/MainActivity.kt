package com.al.kotlin01helloworld

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // 隐藏 ActionBar
        // supportActionBar?.hide()
        // toolbar 取代 ActionBar
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.my_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // 切换显示不同的 Fragment
        when (item.itemId) {
            R.id.firstFragment2 -> navController.navigate(R.id.firstFragment2)
            R.id.secondFragment2 -> navController.navigate(R.id.secondFragment2)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onStart() {
        super.onStart()
        // onStart(): Activity 中获取，需要 Fragment 装载完毕才可以
        navController = findNavController(R.id.fragmentContainerView)

        // 三个 Fragment 没有主次之分
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.firstFragment2,
                R.id.secondFragment2
            )
        )
        toolbar.setupWithNavController(navController, appBarConfiguration)
    }

    // 返回按钮具体功能
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}