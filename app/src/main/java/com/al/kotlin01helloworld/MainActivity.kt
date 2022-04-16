package com.al.kotlin01helloworld

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.al.kotlin01helloworld.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlin.random.Random

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
    name = "settings"
)

class MainActivity : AppCompatActivity() {
    private lateinit var dataBinding: ActivityMainBinding

    val PREF_FILE_NAME = "mydata"
    val NAME_FILED = "name"
    val AGE_FILED = "age"
    val ITEM_KEY = intPreferencesKey("my_int_number")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 隐藏 ActionBar
        supportActionBar?.hide()

        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        with(dataBinding) {
            btnLoad.setOnClickListener {

                MainScope().launch {
                    val num = dataStore.data.map {
                        it[ITEM_KEY]
                    }.firstOrNull()
                    dataBinding.tvInfo.text = num?.toString() ?: "获取数据失败"
                }
            }
            btnSave.setOnClickListener {

                val ranValue = Random.nextInt(1, 100)
                CoroutineScope(Dispatchers.IO).launch {
                    dataStore.edit {
                        it[ITEM_KEY] = ranValue
                    }
                }

                dataBinding.tvInfo.text = "将 $ranValue 写入"
            }
        }
    }
}