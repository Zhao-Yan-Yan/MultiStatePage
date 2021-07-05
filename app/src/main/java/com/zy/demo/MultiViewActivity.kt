package com.zy.demo

import com.zy.demo.base.BaseActivity
import com.zy.demo.base.mockError
import com.zy.demo.base.mockSuccess
import com.zy.demo.databinding.ActivityMultiViewBinding
import com.zy.multistatepage.bindMultiState

class MultiViewActivity : BaseActivity<ActivityMultiViewBinding>() {
    override fun initPage() {

        mockError(viewBinding.mscText)

        val multiState1 = viewBinding.fl1.bindMultiState()
        mockError(multiState1)

        val multiState2 = viewBinding.fl2.bindMultiState()
        mockError(multiState2)

        val multiState3 = viewBinding.fl3.bindMultiState()
        mockError(multiState3)

        val multiState4 = viewBinding.fl4.bindMultiState()
        mockError(multiState4)

        val multiState5 = viewBinding.fl5.bindMultiState()
        mockError(multiState5)
    }
}