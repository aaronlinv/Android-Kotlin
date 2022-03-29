package com.al.kotlin01helloworld

import android.app.Fragment
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // 隐藏 ActionBar
        supportActionBar?.hide()
        myLog("Activity onCreate")
        val fragment = BlankFragment()

        supportFragmentManager.beginTransaction()

            .add(R.id.fragmentContainerView, fragment)
            .commit()

        supportFragmentManager.addFragmentOnAttachListener { fragmentManager, fragment ->
            myLog("Fragment ${fragment.id} is attached")
        }
    }

    // 已废弃，用上面的方式代替
    override fun onAttachFragment(fragment: Fragment?) {
        super.onAttachFragment(fragment)
        myLog("Activity onAttachFragment")
    }

    override fun onStart() {
        super.onStart()
        myLog("Activity onStart")
    }

    override fun onResume() {
        super.onResume()
        myLog("Activity onResume")
    }

    override fun onPause() {
        super.onPause()
        myLog("Activity onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        myLog("Activity onDestroy")
    }
}