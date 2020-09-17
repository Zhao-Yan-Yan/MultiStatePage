package com.zy.multistatepage.entity.banner

import com.google.gson.annotations.SerializedName


/**
 * @ProjectName: WanAndroid
 * @Author: 赵岩
 * @Description: BannerEntity
 * @CreateDate: 2020/9/2 17:51
 */
data class BannerEntity(
    @SerializedName("desc") val desc: String,
    @SerializedName("id") val id: Int,
    @SerializedName("imagePath") val imagePath: String,
    @SerializedName("isVisible") val isVisible: Int,
    @SerializedName("order") val order: Int,
    @SerializedName("title") val title: String,
    @SerializedName("type") val type: Int,
    @SerializedName("url") val url: String
)