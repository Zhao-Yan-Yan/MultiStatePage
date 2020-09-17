package com.zy.multistatepage

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.zy.multistatepage.base.BaseViewModel
import com.zy.multistatepage.entity.banner.BannerEntity

/**
 * @ProjectName: MultiStatePage
 * @Author: 赵岩
 * @Email: 17635289240@163.com
 * @Description: TODO
 * @CreateDate: 2020/9/17 18:18
 */
class TestViewModel(application: Application) : BaseViewModel(application) {
    val response by lazy { MutableLiveData<BannerEntity>() }
    fun testRequest() {
        request(
            requestBlock = {
                apiService.getBanner()
            },
            successBlock = {
                response.postValue(it[0])
            }
        )
    }
}