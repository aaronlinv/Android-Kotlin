package com.al.kotlin01helloworld.vm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.al.kotlin01helloworld.db.MyDatabase
import com.al.kotlin01helloworld.helper.DbHelper
import com.al.kotlin01helloworld.repository.MyDataRepository
import kotlinx.coroutines.launch

/**
 * <pre>
 *     author : Aaron
 *     time   : 2022/04/17
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class MainViewModel(val app: Application) : AndroidViewModel(app) {
    // 实例化 Database 对象
    private val db: MyDatabase by lazy {
        Room.databaseBuilder(
            app,
            MyDatabase::class.java,
            "mydata.db"
        ).build()
    }
    private var myDataRepository: MyDataRepository = MyDataRepository(db)

    val myDataList = myDataRepository.getAllMyData()

    fun addNewData() {
        val obj = DbHelper.createExampleMyData()
        // 使用 ViewModel 协程插入数据
        viewModelScope.launch {
            myDataRepository.add(obj)
        }
    }

}