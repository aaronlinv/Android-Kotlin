package com.al.kotlin01helloworld

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

/**
 * <pre>
 *     author : Aaron
 *     time   : 2022/04/14
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class MyViewModel : ViewModel() {
    fun useCoroutine() {
        viewModelScope.launch {
            myLog("viewModelScope() 中启动协程：${Thread.currentThread().name}")
        }
    }
}