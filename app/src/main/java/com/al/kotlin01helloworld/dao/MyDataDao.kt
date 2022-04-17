package com.al.kotlin01helloworld.dao

import androidx.room.*
import com.al.kotlin01helloworld.entity.MyData

/**
 * <pre>
 *     author : Aaron
 *     time   : 2022/04/16
 *     desc   :
 *     version: 1.0
 * </pre>
 */
@Dao
interface MyDataDao {
    @Insert
    fun add(myData: MyData)

    @Delete
    fun delete(myData: MyData)

    @Update
    fun update(myData: MyData)

    @Query("select * from mydata")
    fun getAll(): List<MyData>

    @Query("select * from mydata where id =:id ")
    fun findById(id: Int): MyData
}