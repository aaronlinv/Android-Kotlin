package com.al.kotlin01helloworld

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myLog("onCreate")

        setContentView(R.layout.activity_main)
        // 隐藏 ActionBar
        supportActionBar?.hide()

        val btnGo: Button = findViewById(R.id.button_go)
        btnGo.setOnClickListener {
            val intent = Intent(this, OtherActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        myLog("onDestroy")
    }

    override fun onPause() {
        super.onPause()
        myLog("onPause")
    }

    override fun onRestart() {
        super.onRestart()
        myLog("onRestart")
    }

    override fun onStart() {
        super.onStart()
        myLog("onStart")
    }

    override fun onResume() {
        super.onResume()
        myLog("onResume")
    }

    override fun onStop() {
        super.onStop()
        myLog("onStop")
    }
}