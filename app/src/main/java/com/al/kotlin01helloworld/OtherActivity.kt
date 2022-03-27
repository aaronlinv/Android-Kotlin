package com.al.kotlin01helloworld

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class OtherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myLog("OtherActivity: onCreate")
        setContentView(R.layout.other_main)
        // 隐藏 ActionBar
        // supportActionBar?.hide()
    }

    override fun onDestroy() {
        super.onDestroy()
        myLog("OtherActivity: onDestroy")
    }

    override fun onPause() {
        super.onPause()
        myLog("OtherActivity: onPause")
    }

    override fun onRestart() {
        super.onRestart()
        myLog("OtherActivity: onRestart")
    }

    override fun onStart() {
        super.onStart()
        myLog("OtherActivity: onStart")
    }

    override fun onResume() {
        super.onResume()
        myLog("OtherActivity: onResume")
    }

    override fun onStop() {
        super.onStop()
        myLog("OtherActivity: onStop")
    }
}