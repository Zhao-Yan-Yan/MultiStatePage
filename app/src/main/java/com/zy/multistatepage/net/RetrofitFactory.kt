package com.zy.multistatepage.net

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @ProjectName: WanAndroid
 * @Author: 赵岩
 * @Description: TODO
 * @CreateDate: 2020/9/2 17:26
 */
object RetrofitFactory {

    private val host = "https://www.wanandroid.com"

    private val retrofit = Retrofit.Builder()
        .baseUrl(host)
        .client(OKHttpManager.okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val mainApiService: ApiService by lazy {
        getService(ApiService::class.java)
    }

    private fun <T> getService(clazz: Class<T>): T {
        return retrofit.create(clazz)
    }
}