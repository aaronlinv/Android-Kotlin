package com.al.kotlin01helloworld.helper

import com.al.kotlin01helloworld.entity.MyData

class DbHelper {
    companion object {
        fun createExampleMyData(): MyData {
            return MyData(1, "First")
        }
    }
}
