package com.zy.demo

import com.zy.demo.base.BaseActivity
import com.zy.demo.base.showSuccess
import com.zy.demo.databinding.ActivitySmartRefreshLayoutBinding
import com.zy.multistatepage.bindMultiState

/**
 * @ProjectName: MultiStatePage
 * @Author: 赵岩
 * @Email: 17635289240@163.com
 * @Description: TODO
 * @CreateDate: 2021/2/9 14:33
 */
class SmartRefreshLayoutActivity : BaseActivity<ActivitySmartRefreshLayoutBinding>() {

    override fun initPage() {
        val multiStateContainer = viewBinding.tv.bindMultiState {

        }
        multiStateContainer.showSuccess()
    }

}