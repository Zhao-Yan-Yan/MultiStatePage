package com.zy.demo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zy.demo.base.BaseFragment
import com.zy.demo.base.mockError
import com.zy.demo.base.mockSuccess
import com.zy.demo.databinding.FragmentMultiStateBinding
import com.zy.multistatepage.MultiStateContainer
import com.zy.multistatepage.bindMultiState
import com.zy.multistatepage.state.LoadingState

/**
 * @ProjectName: MultiStatePage
 * @Author: 赵岩
 * @Email: 17635289240@163.com
 * @Description: TODO
 * @CreateDate: 2020/9/17 14:38
 */
class MultiStateFragment : BaseFragment<FragmentMultiStateBinding>() {
    private lateinit var multiState: MultiStateContainer
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        inflater.inflate(R.layout.activity_api, container, false)
        val root = super.onCreateView(inflater, container, savedInstanceState)
        multiState = root!!.bindMultiState()
        multiState.show<LoadingState>()
        return multiState
    }

    override fun initPage() {
        mockError(multiState)
    }

    companion object {
        fun newInstance(): MultiStateFragment {
            return MultiStateFragment()
        }
    }
}