package com.al.kotlin01helloworld

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

val INPUT_FRAGMENT = "BlankFragment"
val SHOW_FRAGMENT = "ShowFragment"
val MESSAGE_KEY = "message"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // 隐藏 ActionBar
        supportActionBar?.hide()
        switchFragment(INPUT_FRAGMENT, null)
    }

    fun switchFragment(tag: String, message: Bundle?) {
        var fragment = supportFragmentManager.findFragmentByTag(tag)
        if (fragment == null) {
            fragment = when (tag) {
                INPUT_FRAGMENT -> BlankFragment()
                else -> ShowFragment()
            }
        }
        message?.apply {
            fragment.arguments = message
        }
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, fragment)
            .commit()
    }
}