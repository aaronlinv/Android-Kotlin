package com.al.kotlin01helloworld

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * <pre>
 *     author : Aaron
 *     time   : 2022/04/20
 *     desc   :
 *     version: 1.0
 * </pre>
 */
interface MyListServer {
    companion object {
        var baseurl = "https://jinxuliang.com/openservice/"
        val server: MyListServer by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            retrofit.create(MyListServer::class.java)
        }
    }

    @GET("api/test/mydata/{count}")
    suspend fun getMyDataList(@Path("count") count: Int): Response<List<MyData>>
}