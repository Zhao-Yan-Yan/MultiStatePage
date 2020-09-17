package com.zy.multistatepage.net

import com.zy.multistatepage.entity.banner.BannerEntity
import retrofit2.http.GET

/**
 * @ProjectName: WanAndroid
 * @Author: 赵岩
 * @Description: Api
 * @CreateDate: 2020/9/2 17:28
 */
interface ApiService {

    @GET("banner/json")
    suspend fun getBanner(): BaseResponse<MutableList<BannerEntity>>

}