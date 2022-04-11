package com.al.kotlin01helloworld

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.al.kotlin01helloworld.databinding.ActivityMainBinding
import java.time.LocalDateTime

class MainActivity : AppCompatActivity(), MyClickListener {
    private lateinit var dataBinding: ActivityMainBinding
    private lateinit var adapter: MyDataAdapter
    private var dataList = getDataList()
    private var currentIndex: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 隐藏 ActionBar
        supportActionBar?.hide()

        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        adapter = MyDataAdapter(dataList, this)
        dataBinding.tvList.adapter = adapter
        dataBinding.tvList.layoutManager = LinearLayoutManager(this)

        dataBinding.btnAdd.setOnClickListener {
            val newItem = MyDataItem(
                "新添加的数据",
                R.mipmap.ic_avatar,
                LocalDateTime.now()
            )
            val size = dataList.size
            dataList.add(newItem)
            // 通知 Recycle 刷新显示
            adapter.notifyItemInserted(size)
            dataBinding.tvList.scrollToPosition(size)
            showToast(this, "在末尾添加一行 $size")
        }

        dataBinding.btnRemove.setOnClickListener {
            // 未选中
            if (currentIndex == -1) {
                showToast(this, "为选中")
                return@setOnClickListener
            }
            dataList.removeAt(currentIndex)
            adapter.notifyItemRemoved(currentIndex)
            showToast(this, "删除了一行 $currentIndex")
            // 标记为 未选中
            currentIndex = -1
        }

        dataBinding.btnModify.setOnClickListener {
            // 未选中
            if (currentIndex == -1) {
                showToast(this, "为选中")
                return@setOnClickListener
            }
            val newItem = MyDataItem(
                "修改数据",
                R.mipmap.ic_avatar,
                LocalDateTime.now()
            )
            dataList[currentIndex] = newItem
            adapter.notifyItemChanged(currentIndex)
            showToast(this, "修改了一行 $currentIndex")
            // 标记为 未选中
            currentIndex = -1
        }
    }

    private fun getDataList(): MutableList<MyDataItem> {
        return mutableListOf(
            MyDataItem("标题1", R.mipmap.ic_avatar_foreground, LocalDateTime.now()),
            MyDataItem("标题2", R.mipmap.ic_avatar_foreground, LocalDateTime.now()),
            MyDataItem("标题3", R.mipmap.ic_avatar_foreground, LocalDateTime.now()),
            MyDataItem("标题4", R.mipmap.ic_avatar_foreground, LocalDateTime.now()),
            MyDataItem("标题5", R.mipmap.ic_avatar_foreground, LocalDateTime.now())
        )
    }

    override fun onClickRow(index: Int) {
        currentIndex = index
        showToast(this, "点击了一行 $index")
    }
}