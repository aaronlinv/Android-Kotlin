package com.al.kotlin01helloworld

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var tvCount: TextView
    private lateinit var btnAdd: Button
    private lateinit var viewModel: MyViewModel
    private lateinit var viewModelFactory: MyViewModelFactory
    private val myClass = MyClass()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // 隐藏 ActionBar
        supportActionBar?.hide()

        // 方式 1，如果 MyViewModel 是两个参数（其中一个是 Application）可能会报错
        viewModel = ViewModelProvider(this)
            .get(MyViewModel::class.java)
        // 方式 2
        val myViewModelFactory = MyViewModelFactory(application);
        viewModel = ViewModelProvider(this, myViewModelFactory)
            .get(MyViewModel::class.java)


        tvCount = findViewById(R.id.tvCount)
        btnAdd = findViewById(R.id.btnAdd)
        btnAdd.setOnClickListener {
            viewModel.showToast()
        }
        viewModel.appDescription.observe(this) {
            tvCount.text = it
        }

    }
}