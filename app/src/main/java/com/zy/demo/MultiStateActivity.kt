package com.zy.demo

import com.zy.demo.base.BaseActivity
import com.zy.demo.base.mockError
import com.zy.demo.base.mockSuccess
import com.zy.demo.databinding.ActivityMultiStateBinding
import com.zy.multistatepage.bindMultiState

class MultiStateActivity : BaseActivity<ActivityMultiStateBinding>() {

    override fun initPage() {
        val multiStateActivityRoot = bindMultiState {
            mockSuccess(it)
        }
        mockError(multiStateActivityRoot)

        /*val bindMultiState = bindMultiState()
         MainScope().launch {
             bindMultiState.showLoading()
             delay(1000)
             tv.text = "ohhhhhhhhhhhhh"
             bindMultiState.showSuccess()
         }*/
    }

}