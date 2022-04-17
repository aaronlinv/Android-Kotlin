package com.al.kotlin01helloworld.vm

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * <pre>
 *     author : Aaron
 *     time   : 2022/04/17
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class MyViewModelFactory(val app: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(app) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}