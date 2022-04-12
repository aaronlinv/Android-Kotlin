package com.al.kotlin01helloworld

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.al.kotlin01helloworld.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private lateinit var dataBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 隐藏 ActionBar
        supportActionBar?.hide()

        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        with(dataBinding) {
            refreshLayout.setOnRefreshListener {
                tvInfo.text = "正在刷新"
                btnRefresh.isEnabled = true
            }

            btnRefresh.setOnClickListener {
                MainScope().launch {
                    val result = process()
                    tvInfo.text = result
                }
            }
        }

        // 测试协程
        MainScope().launch {
            delay(1000)
            dataBinding.tvInfo.text = "Coroutine 线程名称：${Thread.currentThread().name}"
        }
    }

    // 编写可挂起的函数
    private suspend fun process(): String {
        return withContext(Dispatchers.IO) {
            "Coroutine 使用线程：${Thread.currentThread().name}"
        }
    }
}