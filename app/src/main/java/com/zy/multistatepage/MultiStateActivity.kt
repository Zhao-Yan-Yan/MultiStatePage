package com.zy.multistatepage

import com.zy.multistatepage.base.BaseActivity
import com.zy.multistatepage.base.mock
import com.zy.multistatepage.databinding.ActivityMultiStateBinding

class MultiStateActivity : BaseActivity<ActivityMultiStateBinding>() {

    private val multiStateContainer1 by lazy {
        MultiStatePage.multiState(viewBinding.fl1) {
            load1()
        }
    }

    private val multiStateContainer2 by lazy {
        MultiStatePage.multiState(viewBinding.fl2) {

        }
    }

    private val multiStateContainer3 by lazy {
        MultiStatePage.multiState(viewBinding.img) {

        }
    }

    override fun initPage() {
        mock(multiStateContainer1)
        mock(multiStateContainer2)
        mock(multiStateContainer3)
    }

    fun load1() {
        mock(multiStateContainer1){

        }
    }
}