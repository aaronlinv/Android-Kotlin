package com.al.kotlin01helloworld

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.al.kotlin01helloworld.databinding.ActivityMainBinding
import kotlin.concurrent.thread

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
                val url = "https://jinxuliang.com/openservice/api/imageservice/image_23.jpg"
                thread {
                    val image = getUrlImage(url)
                    runOnUiThread {
                        if (image == null) {
                            dataBinding.tvInfo.text = "图片下载失败"
                        } else {
                            ivImage.setImageBitmap(image)
                        }
                    }
                }
            }
        }
    }
}