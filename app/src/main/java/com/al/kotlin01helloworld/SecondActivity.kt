package com.al.kotlin01helloworld

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
        val user = intent.getParcelableExtra<User>(MainActivity.OBJECT_KEY)

        myLog("name:$name")
        myLog("age:$age")
        myLog("user:$user")
    }
}