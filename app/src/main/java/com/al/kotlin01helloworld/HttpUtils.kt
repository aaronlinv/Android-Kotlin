package com.al.kotlin01helloworld

import java.io.ByteArrayOutputStream
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL

/**
 * <pre>
 *     author : Aaron
 *     time   : 2022/04/18
 *     desc   :
 *     version: 1.0
 * </pre>
 */

// 获取指定 url 资源，并将其转为字符串
fun getUrlString(url: String): String {
    val url = URL(url)
    val connection = url.openConnection() as HttpURLConnection
    try {
        val out = ByteArrayOutputStream()
        out.use {
            val inStream = connection.inputStream
            inStream.use {
                if (connection.responseCode != HttpURLConnection.HTTP_OK) {
                    throw IOException(connection.responseMessage)
                }
                var bytesRead = 0
                val buffer = ByteArray(1024)
                do {
                    bytesRead = inStream.read(buffer)
                    if (bytesRead != -1) {
                        out.write(buffer, 0, bytesRead)
                    }
                } while (bytesRead > 0)
            }
            val bytes = out.toByteArray()
            return String(bytes)
        }
    } finally {
        connection.disconnect()
    }
}