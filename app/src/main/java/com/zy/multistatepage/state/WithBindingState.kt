package com.zy.multistatepage.state

import android.view.View
import com.zy.multistatepage.base.MultiStateBinding
import com.zy.multistatepage.databinding.MultiLottieOtherBinding

/**
 * @ProjectName: MultiStatePage
 * @Author: 赵岩
 * @Email: 17635289240@163.com
 * @Description: TODO
 * @CreateDate: 2020/10/23 10:50
 */
class WithBindingState : MultiStateBinding<MultiLottieOtherBinding>() {

    override fun onMultiStateViewCreate() {
    }

    override fun enableReload(): Boolean = false
}