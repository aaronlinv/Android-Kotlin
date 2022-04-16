package com.al.kotlin01helloworld

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.al.kotlin01helloworld.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var dataBinding: ActivityMainBinding

    val PREF_FILE_NAME = "mydata"
    val NAME_FILED = "name"
    val AGE_FILED = "age"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 隐藏 ActionBar
        supportActionBar?.hide()

        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        with(dataBinding) {
            btnLoad.setOnClickListener {
                val pref = getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE)
                val name = pref.getString(NAME_FILED, "")
                val age = pref.getInt(AGE_FILED, 0)
                dataBinding.tvInfo.text = "姓名：$name 年龄：$age"

                // 遍历
                pref.all.forEach {
                    myLog("${it.key} --> ${it.value}")
                }
            }
            btnSave.setOnClickListener {
                val pref = getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE)
                // 1. 获取编辑器对象
                val editor = pref.edit()
                // 2. 写入数据
                editor.putString(NAME_FILED, "测试名称")
                editor.putInt(AGE_FILED, 18)
                // 3. 提交
                editor.apply()
                dataBinding.tvInfo.text = "数据已经保存"
            }
        }
    }
}