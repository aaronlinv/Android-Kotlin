package com.al.kotlin01helloworld

import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.al.kotlin01helloworld.databinding.ActivityMainBinding

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
                checkNetworkState()
            }
        }
    }

    val callback = object : ConnectivityManager.NetworkCallback() {
        override fun onAvailable(network: Network) {
            super.onAvailable(network)
            showInfo("网络已连接")
        }

        override fun onLost(network: Network) {
            super.onLost(network)
            showInfo("网络已断开")
        }

        override fun onCapabilitiesChanged(
            network: Network,
            networkCapabilities: NetworkCapabilities
        ) {
            super.onCapabilitiesChanged(network, networkCapabilities)
            val info = if (networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                "onCapabilitiesChanged:wifi"
            } else if (networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                "onCapabilitiesChanged:蜂窝网络"
            } else {
                "onCapabilitiesChanged:其他网路"
            }
            showInfo(info)
        }
    }

    private fun checkNetworkState() {
        // 获取对象
        val connMgr = getSystemService(ConnectivityManager::class.java)
        // 注册监听器对象
        val request = NetworkRequest.Builder().build()
        connMgr?.registerNetworkCallback(request, callback)
        dataBinding.tvInfo.text = "网络监听已启动"
    }

    private fun showInfo(info: String) {
        runOnUiThread {
            dataBinding.tvInfo.text = info
        }
    }
}