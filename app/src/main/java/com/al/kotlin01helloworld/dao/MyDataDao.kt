package com.al.kotlin01helloworld.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.al.kotlin01helloworld.entity.MyData
import kotlinx.coroutines.flow.Flow

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
    // 主键冲突时，替换
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(myData: MyData)
    // 使用 suspend 需要添加
    //     implementation "androidx.room:room-ktx:$room_version"

    @Delete
    suspend fun delete(myData: MyData)

    @Update
    suspend fun update(myData: MyData)

    @Query("select * from mydata")
    suspend fun getAll(): List<MyData>

    // LiveData 和 Flow 不用 suspend 修饰
    @Query("select * from mydata")
    fun getAllReturnLiveData(): LiveData<List<MyData>>

    @Query("select * from mydata")
    fun getAllReturnFlow(): Flow<List<MyData>>

    @Query("select * from mydata where id =:id ")
    suspend fun findById(id: Int): MyData
}