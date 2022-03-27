package com.al.kotlin01helloworld

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val tvInfo: TextView = findViewById(R.id.textViewInfo)
        val btnStartNewActivity: Button = findViewById(R.id.buttonStart)
        val btnExit: Button = findViewById(R.id.buttonExit)

        tvInfo.text = "当前栈中有${appManager.activityCount}个Activity"

        btnStartNewActivity.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
        btnExit.setOnClickListener {
            appManager.exitApp(this)
        }
    }
}