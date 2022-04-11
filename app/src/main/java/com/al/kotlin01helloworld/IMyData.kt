package com.al.kotlin01helloworld

import android.content.Context

/**
 * <pre>
 *     author : Aaron
 *     time   : 2022/04/11
 *     desc   :
 *     version: 1.0
 * </pre>
 */
interface IMyData

data class TextData(val context: String) : IMyData

data class ImageData(val imgResId: Int) : IMyData


class DataSource {
    companion object {
        fun getDataList(context: Context): List<IMyData> {
            val dataList = mutableListOf<IMyData>()
            for (i in 1..2) {
                dataList.add(TextData("图片$i"))
                val imageId = context.resources.getIdentifier(
                    "img$i",
                    "drawable",
                    context.packageName
                )
                dataList.add(ImageData(imageId))
            }
            return dataList
        }
    }
}