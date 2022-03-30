package com.al.kotlin01helloworld

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

/**
 * <pre>
 *     author : Aaron
 *     time   : 2022/03/30
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class MyLifecycleObserver() : LifecycleEventObserver {
    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        // 这里尽量处理 UI 控件相关的操作
        when (event) {
            Lifecycle.Event.ON_CREATE -> myLog("MyLifecycleObserver:onCreate")
            Lifecycle.Event.ON_START -> myLog("MyLifecycleObserver:onStart")
            Lifecycle.Event.ON_RESUME -> myLog("MyLifecycleObserver:onResume")

            Lifecycle.Event.ON_PAUSE -> myLog("MyLifecycleObserver:onPause")
            Lifecycle.Event.ON_STOP -> myLog("MyLifecycleObserver:onStop")
            Lifecycle.Event.ON_DESTROY -> myLog("MyLifecycleObserver:onDestroy")
            Lifecycle.Event.ON_ANY -> myLog("MyLifecycleObserver:onAny")
        }
    }
}