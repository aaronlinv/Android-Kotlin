package com.al.kotlin01helloworld

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.onNavDestinationSelected

class MainActivity : AppCompatActivity() {
    private lateinit var btnAdd: Button
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // 隐藏 ActionBar
        // supportActionBar?.hide()
        btnAdd = findViewById(R.id.btnNavigate)
        val hostFragment: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        navController = hostFragment.navController

        btnAdd.setOnClickListener {
            // 导航可以用目的地id、Action id
            // navController.navigate(R.id.secondFragment)

            // 还可以跳转 Activity
            navController.navigate(R.id.navGroup)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.my_nav_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // item 定义的 id 需要和 my_nav_graph 目的地定义的 id 相同，否则无法跳转
        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
    }
}