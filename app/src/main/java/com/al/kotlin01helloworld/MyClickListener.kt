package com.al.kotlin01helloworld

/**
 * <pre>
 *     author : Aaron
 *     time   : 2022/04/11
 *     desc   :
 *     version: 1.0
 * </pre>
 */
interface MyClickListener {
    // 获取点击对象 index 值
    fun onClickRow(index: Int)
}