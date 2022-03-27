package com.al.kotlin01helloworld

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * <pre>
 *     author : Aaron
 *     time   : 2022/03/27
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        // Activity 提供的对象
        val name = intent.getStringExtra(MainActivity.NAME_KEY)
        val age = intent.getIntExtra(MainActivity.AGE_KEY, 0)

        myLog("name:$name")
        myLog("age:$age")

        val intent = Intent().putExtra(ONE_ACTIVITY_RESULT_KEY, "Aaron")

        // 传递数据回去
        setResult(RESULT_OK, intent)
        finish()
    }
}