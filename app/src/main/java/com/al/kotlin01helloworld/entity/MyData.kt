package com.al.kotlin01helloworld.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * <pre>
 *     author : Aaron
 *     time   : 2022/04/16
 *     desc   :
 *     version: 1.0
 * </pre>
 */
@Entity(tableName = "mydata")
data class MyData(
    // 实体必须指定主键
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val info: String
)