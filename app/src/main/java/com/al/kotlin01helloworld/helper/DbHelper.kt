package com.al.kotlin01helloworld.helper

import com.al.kotlin01helloworld.entity.MyData

class DbHelper {
    companion object {
        var id: Int = 0
        fun createExampleMyData(): MyData {
            return MyData(id++, "First")
        }
    }
}
