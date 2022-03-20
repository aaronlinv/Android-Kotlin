package com.al.kotlin01helloworld

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    // 延迟初始化
    private lateinit var tvInfo: TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvInfo = findViewById(R.id.tvInfo)
        val btnCall: Button = findViewById(R.id.btnCall)
        val etPhone: EditText = findViewById(R.id.etPhone)

        etPhone.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                var len = s.toString().length
                if (len == 11) {
                    tvInfo.text = "还需要输 $len 位"
                } else {
                    tvInfo.text = "还需要输 ${11 - len} 位"
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })

        btnCall.setOnClickListener {
            val phoneNum = etPhone.text.toString()
            if (phoneNum.length == 11) {
                callPhone(phoneNum)
            } else {
                showToast(this, "号码格式不正确")
            }
        }
    }

    private fun callPhone(phoneNum: String) {
        val intent = Intent()
        intent.action = Intent.ACTION_DIAL
        // 这个tel不能改，后面的数字可以随便改
        intent.data = Uri.parse("tel:$phoneNum")
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //  AppCompatActivity 对象提供
        menuInflater.inflate(R.menu.my_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menusOpen -> tvInfo.text = "打开"
            R.id.menuSave -> tvInfo.text = "保存"
        }
        return super.onOptionsItemSelected(item)
    }
}