package com.al.kotlin01helloworld

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.al.kotlin01helloworld.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // binding = ActivityMainBinding.inflate(layoutInflater)
        // setContentView(binding.root)
        // 隐藏 ActionBar
        supportActionBar?.hide()

        val dataBinding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        val dataObj = MyDataClass(0)
        dataBinding.sourceObj = dataObj

        dataBinding.btnClick.setOnClickListener {
            dataObj.counter++
            // 容易忽视的重新绑定
            // dataBinding.tvShow.text = dataObj.counter.toString()
        }
    }
}