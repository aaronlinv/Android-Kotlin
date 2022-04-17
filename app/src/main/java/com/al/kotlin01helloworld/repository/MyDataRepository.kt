package com.al.kotlin01helloworld.repository

import androidx.lifecycle.LiveData
import com.al.kotlin01helloworld.db.MyDatabase
import com.al.kotlin01helloworld.entity.MyData

/**
 * <pre>
 *     author : Aaron
 *     time   : 2022/04/17
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class MyDataRepository(private val db: MyDatabase) {
    suspend fun add(myData: MyData) {
        db.myDataDao().add(myData)
    }

    // 每个 Repository 只实例化一个 LiveData，这样外界就可以观察它
    // 使用 lazy 保证只实例化一次
    private val myDataList: LiveData<List<MyData>> by lazy {
        db.myDataDao().getAllReturnLiveData()
    }

    // 暴露获得 LiveData 的方法
    fun getAllMyData(): LiveData<List<MyData>> {
        return myDataList
    }
}