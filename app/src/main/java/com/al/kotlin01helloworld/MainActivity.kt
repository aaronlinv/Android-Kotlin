package com.al.kotlin01helloworld

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    // 延迟初始化
    private lateinit var tvInfo: TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvInfo = findViewById(R.id.tvInfo)
        val btnTest: Button = findViewById(R.id.btnTest)

        tvInfo.text = "hello world"

        var count = 0

        btnTest.setOnClickListener {
            // 闭包：访问外部变量
            count++
            tvInfo.text = "current count is $count"
        }
    }
}