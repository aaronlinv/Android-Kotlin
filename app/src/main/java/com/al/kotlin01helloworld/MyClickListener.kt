package com.al.kotlin01helloworld

/**
 * <pre>
 *     author : Aaron
 *     time   : 2022/04/07
 *     desc   :
 *     version: 1.0
 * </pre>
 */
interface MyClickListener {
    // 获取点击对象 id 值
    fun onClickRow(id: Int)

    // 获取点击对象信息
    fun onClickButtonInRow(message: String)
}