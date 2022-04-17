package com.al.kotlin01helloworld

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.al.kotlin01helloworld.databinding.ActivityMainBinding
import com.al.kotlin01helloworld.db.MyDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var dataBinding: ActivityMainBinding

    // by lazy 延迟初始化
    private val db: MyDatabase by lazy {
        myLog("创建 MyDatabase 对象")

        Room.databaseBuilder(
            this,
            MyDatabase::class.java,
            "mydata.db"
        )
            // Schema 有变化时，自动删除老的数据库，重建新的数据库
            .fallbackToDestructiveMigration()
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 隐藏 ActionBar
        supportActionBar?.hide()

        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        with(dataBinding) {
            btnRefresh.setOnClickListener {
                // useList()
                // useLiveData()
                collectFlow()
            }
        }
    }

    private fun useList() {
        lifecycleScope.launch(Dispatchers.IO) {
            val all = db.myDataDao().getAll()
            runOnUiThread {
                dataBinding.tvInfo.text = all.toString()
            }
        }
    }

    private fun useLiveData() {
        val all = db.myDataDao().getAllReturnLiveData()
        all.observe(this) {
            dataBinding.tvInfo.text = it.toString()
        }
    }

    private fun collectFlow() {
        lifecycleScope.launch {
            val all = db.myDataDao().getAllReturnFlow()
            all.collect {
                dataBinding.tvInfo.text = it.toString()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        db.close()
    }
}