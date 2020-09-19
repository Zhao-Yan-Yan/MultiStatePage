package com.zy.multistatepage.base

import android.app.Application
import com.zy.multistatepage.Config
import com.zy.multistatepage.MultiStatePage
import com.zy.multistatepage.state.LottieOtherState

/**
 * @ProjectName: MultiStatePage
 * @Author: 赵岩
 * @Email: 17635289240@163.com
 * @Description: TODO
 * @CreateDate: 2020/9/17 14:42
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        MultiStatePage.register(LottieOtherState())
    }
}