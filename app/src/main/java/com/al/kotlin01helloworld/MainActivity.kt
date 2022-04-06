package com.al.kotlin01helloworld

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {
    private lateinit var pager: ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // 隐藏 ActionBar
        supportActionBar?.hide()

        pager = findViewById(R.id.viewPager)
        // 实例化适配器对象给 ViewPager2
        pager.adapter = ImageViewPagerAdapter(createImageList())

    }

    private fun createImageList(): List<ImageItem> {
        return listOf(
            ImageItem("Forest", R.drawable.forst),
            ImageItem("Mountain", R.drawable.mountain)
        )
    }
}