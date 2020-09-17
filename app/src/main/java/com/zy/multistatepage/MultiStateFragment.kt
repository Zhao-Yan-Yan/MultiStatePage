package com.zy.multistatepage

import com.zy.multistatepage.base.BaseFragment
import com.zy.multistatepage.base.mock
import com.zy.multistatepage.databinding.FragmentMultiStateBinding

/**
 * @ProjectName: MultiStatePage
 * @Author: 赵岩
 * @Email: 17635289240@163.com
 * @Description: TODO
 * @CreateDate: 2020/9/17 14:38
 */
class MultiStateFragment : BaseFragment<FragmentMultiStateBinding>() {
    override fun initPage() {
        val multiState = MultiStatePage.multiState(viewBinding.fl1)
        mock(multiState)
    }

    companion object {
        fun newInstance(): MultiStateFragment{
            return MultiStateFragment()
        }
    }
}