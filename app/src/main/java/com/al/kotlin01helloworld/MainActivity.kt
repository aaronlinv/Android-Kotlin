package com.al.kotlin01helloworld

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {
    private lateinit var tvInfo: TextView
    private lateinit var etFirst: EditText
    private lateinit var etSecond: EditText

    private val string1 = MutableLiveData<String>()
    private val string2 = MutableLiveData<String>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // 隐藏 ActionBar
        supportActionBar?.hide()
        tvInfo = findViewById(R.id.tvInfo)
        etFirst = findViewById(R.id.etFirst)
        etSecond = findViewById(R.id.etSecond)

        initEditText()
        initMediatorLiveData()
    }

    private fun initEditText() {
        etFirst.addTextChangedListener {
            string1.value = it.toString()
        }
        etSecond.addTextChangedListener {
            string2.value = it.toString()
        }
    }

    private fun initMediatorLiveData() {
        val result = MediatorLiveData<Int>()
        val doSum = Observer<String> {
            val len1 = string1.value?.length ?: 0
            val len2 = string2.value?.length ?: 0
            result.value = len1 + len2
        }
        // 任一变化都会调用 doSum 方法
        result.addSource(string1, doSum)
        result.addSource(string2, doSum)

        result.observe(this) {
            tvInfo.text = result.value.toString() ?: "0"
        }
    }
}