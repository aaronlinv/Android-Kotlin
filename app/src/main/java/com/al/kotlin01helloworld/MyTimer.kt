package com.al.kotlin01helloworld

import android.text.format.DateUtils
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import java.util.*

/**
 * <pre>
 *     author : Aaron
 *     time   : 2022/03/30
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class MyTimer {
    init {
        val timer = Timer()
        val startTime = System.currentTimeMillis()
        var elapsedTime: Long = 0

        // 定时任务
        val task: TimerTask = object : TimerTask() {
            override fun run() {
                elapsedTime = (System.currentTimeMillis() - startTime) / 1000
                // 非 UI 线程，必须用 postValue
                currentTime.postValue(elapsedTime)
            }
        }
        timer.schedule(task, 5000, 1000)
    }

    private val currentTime = MutableLiveData<Long>()

    val currentTimeStrings: LiveData<String> = Transformations.map(currentTime) {
        DateUtils.formatElapsedTime(it)
    }
}