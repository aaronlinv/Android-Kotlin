package com.al.kotlin01helloworld

/**
 * <pre>
 *     author : Aaron
 *     time   : 2022/03/27
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class MyClass() : MyCallback {
    override fun callback() {
        println("MyClass.callback()")
    }
}

interface MyCallback {
    fun callback()
}


// 不加 val 就是只作为参数传入进去
class Worker(private val callback: MyCallback) {
    fun process() {
        println("worker process..")
        callback.callback()
    }
}

fun main() {
    val myClass = MyClass()
    val worker = Worker(myClass)

    worker.process()

    Worker(MyClass()).process()
}

