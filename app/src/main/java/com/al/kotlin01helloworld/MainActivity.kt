package com.al.kotlin01helloworld

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

// Activity 必须实现监听接口
class MainActivity : AppCompatActivity(), BlankFragment.ResponseToFragmentButtonClick {
    private lateinit var tvInfo: TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // 隐藏 ActionBar
        supportActionBar?.hide()
        tvInfo = findViewById<TextView>(R.id.textViewInfo)

        val fragment = BlankFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, fragment)
            .commit()
    }

    override fun responseClick(clickCount: Int) {
        tvInfo.text = clickCount.toString()
    }
}