package com.zy.multistatepage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zy.multistatepage.base.BaseFragment
import com.zy.multistatepage.base.mock
import com.zy.multistatepage.databinding.FragmentGlobalMultiStateBinding

/**
 * @ProjectName: MultiStatePage
 * @Author: 赵岩
 * @Email: 17635289240@163.com
 * @Description: TODO
 * @CreateDate: 2020/9/17 17:26
 */
class GlobalMultiFragment : BaseFragment<FragmentGlobalMultiStateBinding>() {
    lateinit var multiState: MultiStateContainer
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = getViewBindingForFragment(inflater, container)
        multiState = viewBinding.root.multiState()
        return multiState
    }

    override fun initPage() {
        mock(multiState)
    }
    companion object {
        fun newInstance(): GlobalMultiFragment{
            return GlobalMultiFragment()
        }
    }
}