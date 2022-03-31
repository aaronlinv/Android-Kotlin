package com.al.kotlin01helloworld

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

/**
 * <pre>
 *     author : Aaron
 *     time   : 2022/03/31
 *     desc   :
 *     version: 1.0
 * </pre>
 */
// ViewModel 对象需要 Context 时，可以使用 ViewModel 的子类 AndroidViewModel
class MyViewModel(private val app: Application) : AndroidViewModel(app) {


    val appDescription: LiveData<String> =
        MutableLiveData<String>(app.getString(R.string.app_name))

    init {
        myLog("ViewModel 创建")
    }

    override fun onCleared() {
        super.onCleared()
        myLog("ViewModel 销毁")
    }


    // 使用 Context 示例
    fun showToast() {
        Toast.makeText(app, appDescription.value, Toast.LENGTH_SHORT)
            .show()
    }
}