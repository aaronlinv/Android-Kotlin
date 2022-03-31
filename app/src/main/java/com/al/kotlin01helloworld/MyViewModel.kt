package com.al.kotlin01helloworld

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * <pre>
 *     author : Aaron
 *     time   : 2022/03/31
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class MyViewModel(number: Int) : ViewModel() {
    private val _score = MutableLiveData<Int>(number)
    val score: LiveData<Int>
        get() = _score

    init {
        myLog("ViewModel 创建")
    }

    override fun onCleared() {
        super.onCleared()
        myLog("ViewModel 销毁")
    }

    fun changeScore(value: Int) {
        _score.postValue(value)
    }
}