package com.zy.multistatepage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zy.multistatepage.base.BaseActivity
import com.zy.multistatepage.base.mock
import com.zy.multistatepage.databinding.ActivityLottieExtBinding
import com.zy.multistatepage.state.LottieWaitingState
import com.zy.multistatepage.state.SuccessState
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LottieExtActivity : BaseActivity<ActivityLottieExtBinding>() {
    override fun initPage() {
        MultiStatePage.register(LottieWaitingState())

        val multiState = MultiStatePage.multiState(viewBinding.fl)

        MainScope().launch {
            multiState.show<LottieWaitingState>()
            delay(5000)
            multiState.show<SuccessState>()
        }
    }
}