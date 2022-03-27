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
abstract class BaseActivity : AppCompatActivity() {
    val appManager: AppManager = AppManager.instance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appManager.addActivity(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        appManager.finishActivity(this)
    }
}