package com.al.kotlin01helloworld

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    // 延迟初始化
    private lateinit var tvInfo: TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myLog("hello log!")

        tvInfo = findViewById(R.id.tvInfo)
        val btnTest: Button = findViewById(R.id.btnTest)

        tvInfo.text = "hello world"

        var count = 0

        // 参数只有一个，可以用 it
        btnTest.setOnClickListener {
            // 闭包：访问外部变量
            count++
            tvInfo.text = "current count is $count"
            // this -> Activity 对象
            // Toast.makeText(this,"$count",Toast.LENGTH_SHORT).show()
            showToast(this, "$count")

            // as “不安全的”转换操作符，失败抛异常
            (it as Button).text = "我被扁了 $count 次 :-("
        }

        val btnDialog: Button = findViewById(R.id.btnDialog)
        btnDialog.setOnClickListener {
            // 建造者设计模式
            // 静态内部类
            AlertDialog.Builder(this)
                .setPositiveButton("Ok") { _, which ->
                    tvInfo.text = "OK"
                }
                .setNegativeButton("Cancel") { _, which ->
                    tvInfo.text = "Canceled"
                }
                .create()
                .show()
        }
    }
}