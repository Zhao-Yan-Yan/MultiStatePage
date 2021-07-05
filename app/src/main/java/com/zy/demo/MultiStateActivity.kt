package com.zy.demo

import com.zy.demo.base.BaseActivity
import com.zy.demo.base.mockError
import com.zy.demo.base.showEmpty
import com.zy.demo.databinding.ActivityMultiStateBinding
import com.zy.multistatepage.bindMultiState
import com.zy.multistatepage.state.EmptyState
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MultiStateActivity : BaseActivity<ActivityMultiStateBinding>() {

    override fun initPage() {
        val multiStateActivityRoot = bindMultiState().apply { showEmpty() }
        MainScope().launch {
            delay(3000)
            mockError(multiStateActivityRoot)
        }
    }

}