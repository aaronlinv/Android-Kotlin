package com.al.kotlin01helloworld.api

import com.al.kotlin01helloworld.model.ImageCountResponse
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Streaming

/**
 * <pre>
 *     author : Aaron
 *     time   : 2022/04/20
 *     desc   :
 *     version: 1.0
 * </pre>
 */
interface MyWebServer {
    companion object {
        var baseurl = "https://jinxuliang.com/openservice/"
        val server: MyWebServer by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            retrofit.create(MyWebServer::class.java)
        }
    }

    @GET("api/imageservice/count")
    suspend fun getImageCount(): Response<ImageCountResponse>

    @Streaming
    @GET("api/imageservice/{imageName}")
    suspend fun getImage(@Path("imageName") imageName: String): Response<ResponseBody>

}