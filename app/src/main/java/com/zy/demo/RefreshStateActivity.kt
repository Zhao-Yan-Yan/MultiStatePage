package com.zy.demo

import androidx.lifecycle.lifecycleScope
import com.zy.demo.base.BaseActivity
import com.zy.demo.databinding.ActivityRefreshStateBinding
import com.zy.multistatepage.bindMultiState
import com.zy.multistatepage.state.ErrorState
import com.zy.multistatepage.state.LoadingState
import kotlinx.coroutines.delay

class RefreshStateActivity : BaseActivity<ActivityRefreshStateBinding>() {
    private var count = 0
    override fun initPage() {
        val multiStateActivityRoot = bindMultiState()
        lifecycleScope.launchWhenCreated {
            multiStateActivityRoot.show<LoadingState>()
            delay(2000)
            val errorState = ErrorState().apply {
                retry {
                    lifecycleScope.launchWhenCreated {
                        multiStateActivityRoot.show<LoadingState>()
                        delay(2000)
                        multiStateActivityRoot.show<ErrorState> {
                            it.setErrorMsg("鸡你太美 ${++count}")
                            it.setErrorIcon(R.mipmap.jntm)
                        }
                    }
                }
            }
            multiStateActivityRoot.show(errorState)
        }
    }

}