package com.al.kotlin01helloworld

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var lancher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // 隐藏 ActionBar
        supportActionBar?.hide()
        val btnOpen: Button = findViewById(R.id.button)
        val ivOpen: ImageView = findViewById(R.id.imageView)
        // 选取图片后的回调
        lancher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            if (it.resultCode == RESULT_OK) {
                val bitmap = tryReadBitmap(it.data?.data as Uri)
                bitmap?.let {
                    ivOpen.setImageBitmap(bitmap)
                }
            }
        }

        btnOpen.setOnClickListener {
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT

            Intent.createChooser(intent, "选择一张图片")
            lancher.launch(intent)
        }
    }

    private fun tryReadBitmap(data: Uri): Bitmap? {
        return try {
            // 安卓 P 推荐
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                val source = ImageDecoder.createSource(contentResolver, data)
                ImageDecoder.decodeBitmap(source)
            } else {
                //    早期
                MediaStore.Images.Media.getBitmap(contentResolver, data)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            return null
        }
    }
}