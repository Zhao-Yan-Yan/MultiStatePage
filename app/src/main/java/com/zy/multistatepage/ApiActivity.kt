package com.zy.multistatepage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.zy.multistatepage.base.BaseActivity
import com.zy.multistatepage.databinding.ActivityApiBinding
import com.zy.multistatepage.state.*

class ApiActivity : BaseActivity<ActivityApiBinding>() {
    override fun initPage() {

        val multiState = viewBinding.fl.multiState()

        viewBinding.btnLoading.setOnClickListener {
            multiState.show<LoadingState>()
        }


        viewBinding.btnSuccess.setOnClickListener {
            multiState.show<SuccessState>()
        }


        viewBinding.btnEmpty.setOnClickListener {
            multiState.show<EmptyState>()
        }


        viewBinding.btnError.setOnClickListener {
            multiState.show<ErrorState>()
        }


        viewBinding.btnLottie1.setOnClickListener {
            multiState.show<LottieWaitingState>()
        }

        viewBinding.btnLottie2.setOnClickListener {
            multiState.show<LottieOtherState>()
        }

    }
}