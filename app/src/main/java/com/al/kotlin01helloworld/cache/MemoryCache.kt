package com.al.kotlin01helloworld.cache

import android.graphics.Bitmap

/**
 * <pre>
 *     author : Aaron
 *     time   : 2022/06/22
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class MemoryCache {
    companion object {
        private val imageCache = HashMap<String, Bitmap>()

        fun getImage(url: String): Bitmap? {
            return if (imageCache.containsKey(url)) {
                imageCache[url]
            } else {
                null
            }
        }

        // 追加图片，线程安全
        fun putImage(url: String, image: Bitmap) {
            synchronized(MemoryCache::class.java) {
                imageCache[url] = image
            }
        }
    }
}