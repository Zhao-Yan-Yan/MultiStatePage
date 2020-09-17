package com.zy.multistatepage.state

import android.view.View
import com.zy.multistatepage.MultiState
import com.zy.multistatepage.R

/**
 * @ProjectName: MultiStatePage
 * @Author: 赵岩
 * @Email: 17635289240@163.com
 * @Description: TODO
 * @CreateDate: 2020/9/17 14:15
 */
class ErrorState : MultiState() {
    override fun layoutId(): Int = R.layout.mult_state_error

    override fun onMultiStateCreate(view: View) {
    }

    override fun enableReload(): Boolean = true

}