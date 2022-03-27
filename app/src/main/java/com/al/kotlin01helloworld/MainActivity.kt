package com.al.kotlin01helloworld

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    companion object {
        val NAME_KEY: String = "name"
        val AGE_KEY: String = "age"
        val OBJECT_KEY: String = "user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // 隐藏 ActionBar
        supportActionBar?.hide()
        val btnGo: Button = findViewById(R.id.button)
        btnGo.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            val bundle = Bundle()
            // 存入信息
            putMessagesToBundle(bundle)
            putObjectToBundle(bundle)
            // 把 Bundle 交给 Intent
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }

    private fun putObjectToBundle(bundle: Bundle) {
        val user = User("Aaron", 18)
        bundle.putParcelable(OBJECT_KEY, user)
    }

    private fun putMessagesToBundle(bundle: Bundle) {
        bundle.putString(NAME_KEY, "Message")
        bundle.putInt(AGE_KEY, 99)
    }
}