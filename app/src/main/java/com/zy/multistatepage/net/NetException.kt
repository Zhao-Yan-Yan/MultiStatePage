package com.zy.multistatepage.net

import java.lang.Exception

/**
 * @ProjectName: WanAndroid
 * @Author: 赵岩
 * @Description: TODO
 * @CreateDate: 2020/9/2 17:58
 */
class NetException(val errorCode: Int,val errorMsg: String) : Exception(errorMsg) {
    constructor(netError: NetError):this(netError.errorCode,netError.errorMessage)
}