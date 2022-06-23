package com.al.kotlin01helloworld.download

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import com.al.kotlin01helloworld.TAG
import com.al.kotlin01helloworld.cache.FileCache
import com.al.kotlin01helloworld.cache.MemoryCache
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.HttpURLConnection
import java.net.URL

/**
 * <pre>
 *     author : Aaron
 *     time   : 2022/06/22
 *     desc   :
 *     version: 1.0
 * </pre>
 */
suspend fun download(imageUrl: String): Bitmap? {
    return withContext(Dispatchers.IO) {
        var connection: HttpURLConnection? = null
        try {
            connection = URL(imageUrl).openConnection() as HttpURLConnection
            val inputStream = connection.inputStream
            var bitmap: Bitmap? = null;
            inputStream.use {
                bitmap = BitmapFactory.decodeStream(it)
            }
            return@withContext bitmap
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            connection?.disconnect()
        }
        null
    }
}

suspend fun loadImages(context: Context, imageList: List<String>): Map<String, Bitmap> {
    val imageMap = hashMapOf<String, Bitmap>()
    imageList.forEach {
        var bitmap = MemoryCache.getImage(it)
        if (bitmap != null) {
            imageMap[it] = bitmap
            Log.d(TAG, "cache from memory $it")
            return@forEach
        }

        bitmap = FileCache.getImage(context, it)
        if (bitmap != null) {
            imageMap[it] = bitmap
            Log.d(TAG, "cache from file $it")
            return@forEach
        }

        bitmap = download(it)
        Log.d(TAG, "cache from internet $it")

        if (bitmap != null) {
            imageMap[it] = bitmap
            // 写入缓存
            MemoryCache.putImage(it, bitmap)
            FileCache.putImage(context, it, bitmap)
        }

    }
    return imageMap
}