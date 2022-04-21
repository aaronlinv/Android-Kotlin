package com.al.kotlin01helloworld

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.al.kotlin01helloworld.databinding.ActivityMainBinding
import com.al.kotlin01helloworld.model.UiState
import com.al.kotlin01helloworld.viewmodel.MainViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var dataBinding: ActivityMainBinding

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 隐藏 ActionBar
        supportActionBar?.hide()

        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        with(dataBinding) {
            btnLoad.setOnClickListener {
                it.isEnabled = false
                // 协程中启动
                lifecycleScope.launch {
                    viewModel.getAllImage().collect {
                        tvInfo.text = it.info
                        ivImage.setImageBitmap(it.bitmap)
                    }
                }
                it.isEnabled = true
            }
        }
        // 界面更新
        viewModel.currentState.observe(this) {
            when (it!!) {
                UiState.LOADING -> dataBinding.prState.visibility = View.VISIBLE
                UiState.IDLE -> dataBinding.prState.visibility = View.INVISIBLE
                UiState.ERROR -> {
                    dataBinding.prState.visibility = View.INVISIBLE
                    showToast(this, "出错了")
                }
            }
        }
        viewModel.info.observe(this) {
            dataBinding.tvInfo.text = it
        }
    }
}