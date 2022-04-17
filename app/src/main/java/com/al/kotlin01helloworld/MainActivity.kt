package com.al.kotlin01helloworld

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.room.Room
import com.al.kotlin01helloworld.databinding.ActivityMainBinding
import com.al.kotlin01helloworld.db.MyDatabase
import com.al.kotlin01helloworld.helper.DbHelper
import kotlin.concurrent.thread

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
                addToDb()
            }
        }
    }

    fun addToDb() {
        thread {
            val obj = DbHelper.createExampleMyData()
            // 插入数据
            db.myDataDao().add(obj)

            // 取出所有记录
            val allData = db.myDataDao().getAll()

            runOnUiThread {
                dataBinding.tvInfo.text = "$obj 已经插入"
                dataBinding.tvInfo.append("============================\n")
                allData.forEach {
                    dataBinding.tvInfo.append("\n$it \n")
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        db.close()
    }
}