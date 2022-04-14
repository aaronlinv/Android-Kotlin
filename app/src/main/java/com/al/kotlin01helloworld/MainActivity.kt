package com.al.kotlin01helloworld

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.al.kotlin01helloworld.databinding.ActivityMainBinding
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var dataBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 隐藏 ActionBar
        supportActionBar?.hide()

        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        useMainScope()
        useLifecycleScope()
        val vm = ViewModelProvider(this).get(MyViewModel::class.java)
        vm.useCoroutine()

    }

    private fun useMainScope() {
        MainScope().launch {
            myLog("MainScope() 中启动协程：${Thread.currentThread().name}")
        }
    }

    private fun useLifecycleScope() {
        lifecycleScope.launch {
            myLog("lifecycleScope 中启动协程：${Thread.currentThread().name}")
        }

        lifecycleScope.launchWhenStarted {
            myLog("launchWhenStarted 中启动协程：${Thread.currentThread().name}")
        }

        lifecycleScope.launchWhenCreated {
            myLog("launchWhenCreated 中启动协程：${Thread.currentThread().name}")
        }

        lifecycleScope.launchWhenResumed {
            myLog("launchWhenResumed 中启动协程：${Thread.currentThread().name}")
        }
    }
}