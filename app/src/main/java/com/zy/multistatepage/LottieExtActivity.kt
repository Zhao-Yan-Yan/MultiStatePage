package com.zy.multistatepage

import com.zy.multistatepage.base.BaseActivity
import com.zy.multistatepage.base.mockError
import com.zy.multistatepage.base.mockSuccess
import com.zy.multistatepage.databinding.ActivityLottieExtBinding
import com.zy.multistatepage.state.ErrorState
import com.zy.multistatepage.state.LoadingState
import com.zy.multistatepage.state.LottieWaitingState
import com.zy.multistatepage.state.SuccessState
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LottieExtActivity : BaseActivity<ActivityLottieExtBinding>() {
    override fun initPage() {
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