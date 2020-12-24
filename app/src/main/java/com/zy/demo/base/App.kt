package com.zy.demo.base

import android.app.Application
import com.zy.multistatepage.MultiStateConfig
import com.zy.multistatepage.MultiStatePage
import com.zy.multistatepage.R

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
        val config = MultiStateConfig.Builder()
            .alphaDuration(300)
            .errorIcon(R.mipmap.state_error)
            .emptyIcon(R.mipmap.state_empty)
            .emptyMsg("emptyMsg")
            .loadingMsg("loadingMsg")
            .errorMsg("errorMsg")
            .build()

        MultiStatePage.config(config)
    }
}