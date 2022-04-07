package com.al.kotlin01helloworld

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

/**
 * <pre>
 *     author : Aaron
 *     time   : 2022/03/30
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class MyClass {
    private val _counter: MutableLiveData<Int> = MutableLiveData(0)

    // 只读 LiveDate
    val counter: LiveData<Int>
        get() = _counter

    fun addCount() {
        _counter.value = _counter.value?.plus(1)
    }
}