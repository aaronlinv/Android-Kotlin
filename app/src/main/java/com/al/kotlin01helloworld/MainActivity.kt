package com.al.kotlin01helloworld

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // 隐藏 ActionBar
        supportActionBar?.hide()
        val btnCount: Button = findViewById(R.id.button)
        val tvCount: TextView = findViewById(R.id.textView)
        val etCount: EditText = findViewById(R.id.editText)

        btnCount.setOnClickListener {
            counter++
            tvCount.text = "计数值：$counter"
        }
        if (savedInstanceState != null) {
            tvCount.text = "计数值：${savedInstanceState.get("counter")}"
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // 保存实例数据
        outState.putInt("counter", counter)
        myLog("计数值保存：$counter")
    }
}