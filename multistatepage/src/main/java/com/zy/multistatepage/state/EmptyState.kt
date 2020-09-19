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
class EmptyState : MultiState() {

    override fun layoutId(): Int = R.layout.mult_state_empty

    override fun onMultiStateCreate(view: View) = Unit

    override fun enableReload(): Boolean = false

    fun setEmptyMsg(){

    }

    fun setEmptyIcon(){

    }
}