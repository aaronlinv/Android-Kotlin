package com.al.kotlin01helloworld

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

/**
 * <pre>
 *     author : Aaron
 *     time   : 2022/04/06
 *     desc   :
 *     version: 1.0
 * </pre>
 */
// 可观察的类
class MyDataClass(_text: String) : BaseObservable() {
    @get:Bindable
    var text: String = _text
        set(value) {
            field = value
            // 赋值时通知外界值改变了
            // BR 类由 kotlin-kapt 插件生成
            notifyPropertyChanged(BR.text)
        }
}