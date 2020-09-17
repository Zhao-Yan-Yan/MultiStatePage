package com.zy.multistatepage.net

import com.google.gson.annotations.SerializedName

/**
 * @ProjectName: WanAndroid
 * @Author: 赵岩
 * @Description: TODO
 * @CreateDate: 2020/9/2 17:36
 */
data class BaseResponse<T>(
    @SerializedName("errorCode") val errorCode: Int,
    @SerializedName("errorMsg") val errorMsg: String,
    @SerializedName("data") val data: T
) {
    fun isSuccess(): Boolean = errorCode == 0
}