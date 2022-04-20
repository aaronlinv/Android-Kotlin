package com.al.kotlin01helloworld

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.al.kotlin01helloworld.databinding.ActivityMainBinding
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException
import java.net.URLEncoder
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    private val serverUrl: String =
        "https://jinxuliang.com/openservice/api/OnlineCalculator/Calculate"
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
                // testHttpGet()
                // testHttpGetAsync()
                testHttpPost()
            }
        }
    }

    private fun testHttpGetAsync() {
        try {
            calculateAsync(dataBinding.etExpr.text.toString().trim())
        } catch (ex: Exception) {
            showMessage(ex.message!!)
        }
    }

    private fun calculateAsync(expr: String) {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url("$serverUrl?expr=${URLEncoder.encode(expr, "utf-8")}")
            .build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                showMessage(e.message!!)
            }

            override fun onResponse(call: Call, response: Response) {
                showResponseInfo(response)
            }
        })
    }

    private fun testHttpGet() {
        thread {
            try {
                calculate(dataBinding.etExpr.text.toString().trim())

            } catch (ex: Exception) {
                showMessage(ex.message!!)
            }
        }
    }

    private fun calculate(expr: String) {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url("$serverUrl?expr=${URLEncoder.encode(expr, "utf-8")}")
            .build()
        val response = client.newCall(request)
            .execute()
        showResponseInfo(response)
    }

    private fun testHttpPost() {
        thread {
            try {
                calculateViaPost(dataBinding.etExpr.text.toString().trim())
            } catch (ex: Exception) {
                showMessage(ex.message!!)
            }
        }
    }

    private fun calculateViaPost(expr: String) {
        val client = OkHttpClient()
        val context = "{expr:'$expr'}"
        val body = context.toRequestBody("application/json".toMediaType())
        val request = Request.Builder()
            .url(serverUrl)
            .addHeader("Accept", "application/json")
            .post(body)
            .build()
        val response = client.newCall(request).execute()
        showResponseInfo(response)
    }

    // 同步调用
    private fun showResponseInfo(response: Response) {
        val responseBody = response.body!!.string()
        if (response.isSuccessful) {
            showMessage(responseBody)
        } else {
            showMessage("出错了，状态码：${response.code}\n$responseBody")
        }
    }

    private fun showMessage(s: String) {
        runOnUiThread {
            dataBinding.tvInfo.text = s
        }
    }
}