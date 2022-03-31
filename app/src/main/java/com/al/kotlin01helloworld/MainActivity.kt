package com.al.kotlin01helloworld

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var btnAdd: Button
    lateinit var viewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // 隐藏 ActionBar
        supportActionBar?.hide()

        btnAdd = findViewById(R.id.btnAdd)
        btnAdd.setOnClickListener {
            val initValue = viewModel.score.value!!
            viewModel.changeScore(initValue + 1)
        }
        val blankFragment = BlankFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, blankFragment, "blank_fragment")
            .commit()
    }

    override fun onStart() {
        super.onStart()
        // 注意要在 onStart 才可以找到对应 Fragment
        // 在xml 中定义 id 和 tag 似乎不太管用
        val blankFragment = supportFragmentManager.findFragmentByTag("blank_fragment")
        // val blankFragment = supportFragmentManager.findFragmentById(R.id.blankFragment)
        viewModel = (blankFragment as BlankFragment).viewModel
    }
}