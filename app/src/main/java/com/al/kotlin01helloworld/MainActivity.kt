package com.al.kotlin01helloworld

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var tvCount: TextView
    private lateinit var btnAdd: Button
    private val myClass = MyClass()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // 隐藏 ActionBar
        supportActionBar?.hide()
        tvCount = findViewById(R.id.tvCount)
        btnAdd = findViewById(R.id.btnAdd)
        btnAdd.setOnClickListener {
            myClass.addCount()
        }
        myClass.counter.observe(this) {
            tvCount.text = it.toString()
        }
    }
}