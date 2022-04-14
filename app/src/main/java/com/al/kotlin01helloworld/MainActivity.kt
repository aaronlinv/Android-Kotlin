package com.al.kotlin01helloworld

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.al.kotlin01helloworld.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 隐藏 ActionBar
        supportActionBar?.hide()

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val viewModel = ViewModelProvider(this)
            .get(MainViewModel::class.java)
        with(binding) {
            btnRun.setOnClickListener {
                if (viewModel.currentState.value != WorkState.WORKING) {
                    viewModel.doWork()
                } else {
                    viewModel.cancel()
                }
            }
        }

        viewModel.workingInfo.observe(this) {
            binding.tvInfo.text = it
        }
        viewModel.currentState.observe(this) {
            when (it) {
                WorkState.WORKING -> {
                    binding.pgWorkingr.visibility = View.VISIBLE
                    binding.btnRun.text = "取消"
                }

                WorkState.IDLE -> {
                    binding.pgWorkingr.visibility = View.INVISIBLE
                    binding.btnRun.text = "运行"
                }

                WorkState.CANCELED -> {
                    binding.pgWorkingr.visibility = View.INVISIBLE
                    binding.tvInfo.text = "取消"
                    binding.btnRun.text = "运行"
                }
            }
        }
    }
}