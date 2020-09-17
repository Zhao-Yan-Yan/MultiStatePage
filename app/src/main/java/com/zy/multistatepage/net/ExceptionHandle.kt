package com.zy.multistatepage.net

import android.net.ParseException
import com.google.gson.JsonParseException
import com.google.gson.stream.MalformedJsonException
import org.apache.http.conn.ConnectTimeoutException
import org.json.JSONException
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.net.ssl.SSLException

/**
 * @ProjectName: WanAndroid
 * @Author: 赵岩
 * @Description: 异常处理中心
 * @CreateDate: 2020/9/2 18:04
 */
object ExceptionHandle {

    fun handleException(e: Throwable): NetException {
        return when (e) {
            is HttpException -> NetException(NetError.NETWORK_ERROR)
            is JsonParseException, is JSONException, is ParseException, is MalformedJsonException -> NetException(
                NetError.PARSE_ERROR
            )
            is ConnectException -> NetException(NetError.NETWORK_ERROR)
            is SSLException -> NetException(NetError.SSL_ERROR)
            is ConnectTimeoutException, is SocketTimeoutException, is UnknownHostException -> NetException(
                NetError.TIMEOUT_ERROR
            )
            else -> NetException(NetError.UNKNOWN)
        }
    }
}