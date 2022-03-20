package com.al.kotlin01helloworld

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    // 延迟初始化
    private lateinit var tvInfo: TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnChange: Button = findViewById(R.id.btnChange)
        val imageView: ImageView = findViewById(R.id.imageView)

        val imageList = mutableListOf<Int>(R.drawable.mountain, R.drawable.forst)
        var count = 1
        btnChange.setOnClickListener {
            count++
            imageView.setImageResource(imageList.get(count % imageList.size))
        }

    }
}