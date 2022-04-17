package com.al.kotlin01helloworld.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.al.kotlin01helloworld.dao.MyDataDao
import com.al.kotlin01helloworld.entity.MyData

/**
 * <pre>
 *     author : Aaron
 *     time   : 2022/04/16
 *     desc   :
 *     version: 1.0
 * </pre>
 */
@Database(
    // 表明数据库中有几张表
    entities = [MyData::class],
    // 数据库版本
    version = 1
)
abstract class MyDatabase : RoomDatabase() {
    //
    abstract fun myDataDao(): MyDataDao
}