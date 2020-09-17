package com.zy.multistatepage.net

/**
 * @ProjectName: WanAndroid
 * @Author: 赵岩
 * @Description: 网络请求错误类型
 * @CreateDate: 2020/9/2 18:01
 */
enum class NetError(
    val errorCode: Int,
    val errorMessage: String
) {
    UNKNOWN(1000, "请求失败，请稍后再试"),
    PARSE_ERROR(1001, "解析错误，请稍后再试"),
    NETWORK_ERROR(1002, "网络连接错误，请稍后重试"),
    SSL_ERROR(1003, "证书出错，请稍后再试"),
    TIMEOUT_ERROR(1004, "网络连接超时，请稍后重试");
}