package com.al.kotlin01helloworld

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.al.kotlin01helloworld.databinding.ActivityMainBinding

// Recycle 的 Holder 一般数量会比较大，如果 new 监听器 会影响性能，一般用单例
class MainActivity : AppCompatActivity(), MyClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 隐藏 ActionBar
        supportActionBar?.hide()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val rvItem = binding.rvItem
        // 布局管理器
        // 没有设置这个不会显示
        rvItem.layoutManager = LinearLayoutManager(this)

        val myDataAdapter = MyDataAdapter(createItemList(), this)
        binding.rvItem.adapter = myDataAdapter
    }

    private fun createItemList(): List<MyData> {
        return listOf(
            MyData(10, "First"),
            MyData(20, "First"),
            MyData(30, "First"),
            MyData(40, "First"),
            MyData(50, "First"),
            MyData(60, "First"),
            MyData(70, "First"),
            MyData(70, "First"),
            MyData(70, "First"),
            MyData(70, "First"),
            MyData(70, "First"),
            MyData(70, "First"),
        )
    }

    override fun onClickRow(id: Int) {
        showToast(this, "onClickRow $id")
    }

    override fun onClickButtonInRow(message: String) {
        showToast(this, "onClickButtonInRow $message")
    }
}