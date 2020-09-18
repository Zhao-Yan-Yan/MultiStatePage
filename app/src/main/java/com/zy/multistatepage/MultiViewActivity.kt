package com.zy.multistatepage

import com.zy.multistatepage.base.BaseActivity
import com.zy.multistatepage.base.mockError
import com.zy.multistatepage.base.mockSuccess
import com.zy.multistatepage.databinding.ActivityMultiViewBinding

class MultiViewActivity : BaseActivity<ActivityMultiViewBinding>() {
    override fun initPage() {
        val multiState1 = viewBinding.fl1.multiState {
            mockSuccess(it)
        }
        mockError(multiState1)

        val multiState2 = viewBinding.fl2.multiState {
            mockSuccess(it)
        }
        mockError(multiState2)

        val multiState5 = viewBinding.fl5.multiState {
            mockSuccess(it)
        }
        mockError(multiState5)
    }
}