package com.al.kotlin01helloworld

import java.time.LocalDateTime

/**
 * <pre>
 *     author : Aaron
 *     time   : 2022/04/11
 *     desc   :
 *     version: 1.0
 * </pre>
 */
data class MyDataItem(
    val title: String,
    val imgId: Int,
    val date: LocalDateTime
)