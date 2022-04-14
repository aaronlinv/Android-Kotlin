package com.al.kotlin01helloworld

import kotlin.concurrent.thread

/**
 * <pre>
 *     author : Aaron
 *     time   : 2022/04/13
 *     desc   :
 *     version: 1.0
 * </pre>
 */
fun main() {
    thread(start = true, name = "自定义工作线程") {
        (1..3).forEach {
            println("线程 ${Thread.currentThread().name} 正在处理 $it")
        }
    }
    (1..3).forEach {
        println("线程 ${Thread.currentThread().name} 正在处理 $it")
    }
}