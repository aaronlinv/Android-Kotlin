package com.al.kotlin01helloworld

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    // 伴生对象，类似 Java 静态成员变量
    companion object {
        var globalCount: Int = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // 隐藏 ActionBar
        supportActionBar?.hide()
        val btnCount: Button = findViewById(R.id.button)
        val tvCount: TextView = findViewById(R.id.textView)
        val etCount: EditText = findViewById(R.id.editText)

        btnCount.setOnClickListener {
            globalCount++
            tvCount.text = "计数值：$globalCount"
        }
    }
}