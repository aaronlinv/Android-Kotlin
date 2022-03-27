package com.al.kotlin01helloworld

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity


const val ONE_ACTIVITY_RESULT_KEY = "result_key"

class MainActivity : AppCompatActivity() {
    lateinit var launcher: ActivityResultLauncher<Intent>

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
        val tvResult: TextView = findViewById(R.id.textViewResult)

        // 注册启动器回调
        launcher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            // 检查结果码
            if (it.resultCode == RESULT_OK) {
                tvResult.text = it.data?.getStringExtra(ONE_ACTIVITY_RESULT_KEY)
            } else {
                tvResult.text = "用户撤销了操作"
            }
        }

        btnGo.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            val bundle = Bundle()
            // 存入信息
            putMessagesToBundle(bundle)
            // 把 Bundle 交给 Intent
            intent.putExtras(bundle)
            launcher.launch(intent)
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