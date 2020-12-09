package com.zy.multistatepage

import com.zy.multistatepage.base.BaseActivity
import com.zy.multistatepage.base.mockError
import com.zy.multistatepage.base.mockSuccess
import com.zy.multistatepage.databinding.ActivityMultiViewBinding

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