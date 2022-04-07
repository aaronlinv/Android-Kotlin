package com.al.kotlin01helloworld

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * <pre>
 *     author : Aaron
 *     time   : 2022/03/30
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class CounterViewModel : ViewModel() {
    private val _counter: MutableLiveData<Int> = MutableLiveData(0)

    // 只读 LiveDate
    val counter: LiveData<Int>
        get() = _counter

    fun addCount() {
        val currentValue = _counter.value ?: 0
        _counter.value = currentValue + 1
    }
}