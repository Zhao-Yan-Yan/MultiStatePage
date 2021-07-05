package com.zy.demo

import com.zy.demo.databinding.ActivityLottieExtBinding
import com.zy.multistatepage.MultiStateContainer
import com.zy.multistatepage.MultiStatePage
import com.zy.demo.base.BaseActivity
import com.zy.multistatepage.state.ErrorState
import com.zy.demo.state.LottieWaitingState
import com.zy.multistatepage.state.SuccessState
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LottieExtActivity : BaseActivity<ActivityLottieExtBinding>() {
    override fun initPage() {
        MultiStatePage.bindMultiState(viewBinding.fl)
        val multiState = MultiStatePage.bindMultiState(viewBinding.fl) {
            mockSuccess(it)
        }
        mockError(multiState)
    }


    private fun mockError(multiStateContainer: MultiStateContainer) {
        MainScope().launch {
            multiStateContainer.show<LottieWaitingState>()
            val delayTime = (10..30).random() * 100.toLong()
            delay(delayTime)
            multiStateContainer.show<ErrorState>()
        }
    }

    private fun mockSuccess(multiStateContainer: MultiStateContainer) {
        MainScope().launch {
            multiStateContainer.show<LottieWaitingState>()
            val delayTime = (10..30).random() * 100.toLong()
            delay(delayTime)
            multiStateContainer.show<SuccessState>()
        }
    }
}