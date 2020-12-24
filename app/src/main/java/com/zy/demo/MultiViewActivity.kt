package com.zy.demo

import com.zy.demo.base.BaseActivity
import com.zy.demo.base.mockError
import com.zy.demo.base.mockSuccess
import com.zy.demo.databinding.ActivityMultiViewBinding
import com.zy.multistatepage.bindMultiState

class MultiViewActivity : BaseActivity<ActivityMultiViewBinding>() {
    override fun initPage() {

        val multiState1 = viewBinding.fl1.bindMultiState {
            mockSuccess(it)
        }
        mockError(multiState1)

        val multiState2 = viewBinding.fl2.bindMultiState {
            mockSuccess(it)
        }
        mockError(multiState2)

        val multiState3 = viewBinding.fl3.bindMultiState {
            mockSuccess(it)
        }
        mockError(multiState3)

        val multiState4 = viewBinding.fl4.bindMultiState {
            mockSuccess(it)
        }
        mockError(multiState4)

        val multiState5 = viewBinding.fl5.bindMultiState {
            mockSuccess(it)
        }
        mockError(multiState5)
    }
}