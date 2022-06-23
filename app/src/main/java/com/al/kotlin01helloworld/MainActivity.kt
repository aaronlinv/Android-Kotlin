package com.al.kotlin01helloworld

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.al.kotlin01helloworld.adapter.ImageListAdapter
import com.al.kotlin01helloworld.databinding.ActivityMainBinding
import com.al.kotlin01helloworld.download.loadImages
import com.al.kotlin01helloworld.model.WebImage
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var dataBinding: ActivityMainBinding
    private var adapter: ImageListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 隐藏 ActionBar
        supportActionBar?.hide()

        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        dataBinding.imageListView.layoutManager = LinearLayoutManager(this)

        dataBinding.btnLoad.setOnClickListener {
            downloadImageList()
        }
        dataBinding.btnClear.setOnClickListener {
            adapter?.clear()
        }
    }

    private fun getImageUrlList(): List<String> {
        val list = arrayListOf<String>()
        for (i in 1..9) {
            // https://jinxuliang.com/images/image_01
            val url = "$WEB_IMAGE_BASE_URL/image_0$i.jpg"
            list.add(url)
        }
        return list
    }

    private fun downloadImageList() {
        lifecycleScope.launch {
            val imageUrlList = getImageUrlList()

            val imageMap = loadImages(
                this@MainActivity,
                imageUrlList
            )

            val list = ArrayList<WebImage>()
            imageMap.forEach {
                list.add(WebImage(it.key, it.value))
            }

            adapter = ImageListAdapter(list)
            dataBinding.imageListView.adapter = adapter
        }
    }
}