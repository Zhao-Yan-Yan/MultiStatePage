package com.zy.multistatepage.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.zy.multistatepage.net.BaseResponse
import com.zy.multistatepage.net.NetException
import com.zy.multistatepage.net.RetrofitFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

/**
 * @ProjectName: WanAndroid
 * @Author: 赵岩
 * @Description: TODO
 * @CreateDate: 2020/9/1 16:15
 */
open class BaseViewModel(application: Application) : AndroidViewModel(application) {
    val apiService by lazy { RetrofitFactory.mainApiService }

    val pageStateChange: PageStateChange = PageStateChange()

    inner class PageStateChange {
        val showEmpty by lazy { MutableLiveData<String>() }
        val showContent by lazy { MutableLiveData<Boolean>() }
        val showError by lazy { MutableLiveData<String>() }
        val showLoading by lazy { MutableLiveData<String>() }
    }

    fun <T> request(
        requestBlock: suspend () -> BaseResponse<T>,
        successBlock: (T) -> Unit = {},
        errorBlock: (t: Throwable) -> Unit = {}
    ) {
        viewModelScope.launch {
            try {
                pageStateChange.showLoading.postValue("loading...")
                val response = withContext(Dispatchers.IO) { requestBlock.invoke() }
                if (response.isSuccess()) {
                    pageStateChange.showContent.postValue(true)
                    successBlock.invoke(response.data)
                } else {
                    throw NetException(response.errorCode, response.errorMsg)
                }
            } catch (e: Exception) {
                pageStateChange.showError.postValue(e.message.toString())
                e.printStackTrace()
                errorBlock.invoke(e)
            }
        }
    }

}