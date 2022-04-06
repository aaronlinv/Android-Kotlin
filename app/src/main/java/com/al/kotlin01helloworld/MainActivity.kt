package com.al.kotlin01helloworld

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.al.kotlin01helloworld.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // 隐藏 ActionBar
        supportActionBar?.hide()
        var counter = 0
        with(binding) {
            btnAdd.setOnClickListener {
                counter++
                tvCount.text = counter.toString()
            }
        }
    }
}