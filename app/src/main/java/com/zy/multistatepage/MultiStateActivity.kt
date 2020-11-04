package com.zy.multistatepage

import com.zy.multistatepage.base.BaseActivity
import com.zy.multistatepage.base.mockError
import com.zy.multistatepage.base.mockRandom
import com.zy.multistatepage.base.mockSuccess
import com.zy.multistatepage.databinding.ActivityMultiStateBinding

class MultiStateActivity : BaseActivity<ActivityMultiStateBinding>() {

    override fun initPage() {
        val multiStateActivityRoot = bindMultiState {
            mockSuccess(it)
        }
        mockError(multiStateActivityRoot)
    }

}