package com.zy.multistatepage.state

import android.view.View
import android.widget.TextView
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
    var errorMsg = "异常"
    override fun layoutId(): Int = R.layout.mult_state_error

    override fun onMultiStateCreate(view: View) {
        view.findViewById<TextView>(R.id.tv_error_msg).text = errorMsg
    }

    override fun enableReload(): Boolean = true

    override fun onDestroy() {
        super.onDestroy()
        errorMsg = "戳错了"
    }
}