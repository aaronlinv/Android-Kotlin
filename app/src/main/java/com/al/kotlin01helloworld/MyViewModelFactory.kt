package com.al.kotlin01helloworld

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * <pre>
 *     author : Aaron
 *     time   : 2022/03/31
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class MyViewModelFactory(val number: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MyViewModel::class.java)) {
            return MyViewModel(number) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}