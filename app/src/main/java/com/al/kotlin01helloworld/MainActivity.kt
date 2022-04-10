package com.al.kotlin01helloworld

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.al.kotlin01helloworld.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // 隐藏 ActionBar
        supportActionBar?.hide()
        val myName = MyName("宋江", "及时雨")

        //     with(binding) {
        //         tvName.text = myName.name
        //         tvNickname.text = myName.nickname
        //     }
        var dataBinding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        dataBinding.myName = myName
        // 直接用视图绑定的对象也可以
        // binding.myName = myName

    }
}