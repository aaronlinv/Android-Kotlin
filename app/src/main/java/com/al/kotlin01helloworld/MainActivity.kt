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
        val photoUrl =
            "https://tenfei04.cfp.cn/creative/vcg/800/new/VCG211177178924.jpg"
        binding.imageUrl = ""

        binding.btnLoad.setOnClickListener {
            binding.imageUrl = photoUrl
        }
    }
}