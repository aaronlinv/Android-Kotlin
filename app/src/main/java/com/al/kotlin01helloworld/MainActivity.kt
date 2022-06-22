package com.al.kotlin01helloworld

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.al.kotlin01helloworld.databinding.ActivityMainBinding
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    private lateinit var dataBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 隐藏 ActionBar
        supportActionBar?.hide()

        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        Glide.with(this)

        dataBinding.btnDownload.setOnClickListener {
            Glide
                .with(this)
                .load(Uri.parse("https://jinxuliang.com/images/image_01.jpg"))
                .into(dataBinding.imageView)
        }
    }
}