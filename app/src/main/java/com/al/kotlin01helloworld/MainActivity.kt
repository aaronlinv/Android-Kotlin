package com.al.kotlin01helloworld

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.al.kotlin01helloworld.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private lateinit var dataBinding: ActivityMainBinding
    private var job: Job? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 隐藏 ActionBar
        supportActionBar?.hide()

        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        with(dataBinding) {
            val threadName = Thread.currentThread().name
            tvInfo.text = threadName

            btnRefresh.setOnClickListener {
                job = MainScope().launch {
                    it.isEnabled = false
                    tvInfo.text = "协程启动..."
                    // 自动切换到后台执行计算，同时显示进度
                    val result = calculateUseCoroutine()
                    // 挂起函数后，会切换回主线程，执行下面代码
                    tvInfo.text = "计算的结果为：$result，协程：${job}"
                    it.isEnabled = true
                }
            }
        }
    }

    private suspend fun calculateUseCoroutine(): Long {
        // CPU 密集型使用 Default
        return withContext(Dispatchers.Default) {
            var sum: Long = 0
            for (i in 1..100) {
                sum += i
                delay(80)
                if (i % 10 == 0) {
                    showProgress(i)
                    myLog("正在处理 ${i},${Thread.currentThread().name}")
                }
            }
            sum
        }
    }

    // UI 线程
    private suspend fun showProgress(percent: Int) {
        withContext(Dispatchers.Main) {
            dataBinding.tvInfo.text = percent.toString()
        }
    }

    override fun onStop() {
        super.onStop()
        job?.cancel()
        myLog("onStop，协程被取消：$job")
        dataBinding.btnRefresh.isEnabled = true
    }
}