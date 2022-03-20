package com.al.kotlin01helloworld

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    // 延迟初始化
    private lateinit var tvInfo: TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvInfo = findViewById(R.id.tvInfo)
        tvInfo.text = "未选中菜单"
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