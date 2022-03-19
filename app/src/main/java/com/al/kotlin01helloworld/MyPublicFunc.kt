package com.al.kotlin01helloworld

import android.content.Context
import android.util.Log
import android.widget.Toast

/**
 * <pre>
 *     author : Aaron
 *     time   : 2022/03/19
 *     desc   :
 *     version: 1.0
 * </pre>
 */

// 类外部定义的 顶层属性 顶层函数 整个项目可用
val TAG = "MainActivity"

// Any 类似 Java 的 Object，? 代表可空
fun myLog(info: Any?) {
    if (info != null) {
        Log.d(TAG, info.toString())
    }
}

fun showToast(context:Context,info:String){
    Toast.makeText(context,info,Toast.LENGTH_SHORT).show()
}
