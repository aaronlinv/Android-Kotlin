package com.al.kotlin01helloworld

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.al.kotlin01helloworld.databinding.ActivityMainBinding
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var dataBinding: ActivityMainBinding
    private val imageServer: MyImageServer = MyImageServer.imageServer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 隐藏 ActionBar
        supportActionBar?.hide()
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        with(dataBinding) {

        }
        dataBinding.btnLoad.setOnClickListener {
            getNewestImageUseCallback()
        }
    }

    private fun getNewestImageUseCallback() {
        val call = imageServer.getImageCount()
        // Retrofit 采用队列的方式
        call.enqueue(object : Callback<ImageCountResponse> {
            override fun onResponse(
                call: Call<ImageCountResponse>,
                response: Response<ImageCountResponse>
            ) {
                val result = response.body()
                if (result != null) {
                    val imageName = "image_${result.imageCount}.jpg"
                    myLog("拼接后的图片名称：${imageName}")

                    val call2 = imageServer.getImage(imageName)
                    call2.enqueue(object : Callback<ResponseBody> {
                        override fun onResponse(
                            call: Call<ResponseBody>,
                            response: Response<ResponseBody>
                        ) {
                            val stream = response.body()?.byteStream()
                            val bitmap: Bitmap?
                            stream.use {
                                bitmap = BitmapFactory.decodeStream(stream)
                            }
                            runOnUiThread {
                                dataBinding.ivImage.setImageBitmap(bitmap)
                            }
                        }

                        override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                            showInfo(t.message!!)
                        }

                    })
                }
            }

            override fun onFailure(call: Call<ImageCountResponse>, t: Throwable) {
                showInfo(t.message!!)
            }

        })
    }

    private fun showInfo(message: String) {
        showToast(this, message)
    }
}