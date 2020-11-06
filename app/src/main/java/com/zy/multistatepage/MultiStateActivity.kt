package com.zy.multistatepage

import com.zy.multistatepage.base.*
import com.zy.multistatepage.databinding.ActivityMultiStateBinding

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