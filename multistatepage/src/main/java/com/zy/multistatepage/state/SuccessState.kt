package com.zy.multistatepage.state

import android.view.View
import com.zy.multistatepage.MultiState

/**
 * @ProjectName: MultiStatePage
 * @Author: 赵岩
 * @Email: 17635289240@163.com
 * @Description: TODO
 * @CreateDate: 2020/9/17 14:11
 */
class SuccessState : MultiState() {
    override fun layoutId(): Int = 0

    override fun onMultiStateCreate(view: View) = Unit

    override fun enableReload(): Boolean = false
}