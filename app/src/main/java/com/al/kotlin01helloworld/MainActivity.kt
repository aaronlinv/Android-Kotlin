package com.al.kotlin01helloworld

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var fragmentIndex = 0
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // 隐藏 ActionBar
        supportActionBar?.hide()

        var btnCreate: Button = findViewById(R.id.buttonCreate)
        var btnRemove: Button = findViewById(R.id.buttonRemove)

        btnCreate.setOnClickListener {
            // 实例化 Fragment
            val name = "BlankFragment ${++fragmentIndex}"
            val fragment = MyFirstFragment(name)
            // 添加到 Activity 中
            supportFragmentManager.beginTransaction()
                // 添加到栈中，可以通过返回键，回退到上一个 Fragment
                .addToBackStack(null)
                .add(R.id.fragmentContainerView, fragment, "blank")
                .commit()
        }

        btnRemove.setOnClickListener {
            val fragment = supportFragmentManager.findFragmentByTag("blank")
            if (fragment != null) {
                supportFragmentManager.beginTransaction()
                    .remove(fragment)
                    .commit()
            }
        }
    }
}