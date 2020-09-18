package com.zy.multistatepage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.zy.multistatepage.base.BaseActivity
import com.zy.multistatepage.databinding.ActivityMockNetBinding
import com.zy.multistatepage.state.ErrorState
import com.zy.multistatepage.state.LottieWaitingState
import com.zy.multistatepage.state.SuccessState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import java.lang.Exception

class MockNetActivity : BaseActivity<ActivityMockNetBinding>() {
    private lateinit var multiState: MultiStateContainer
    override fun initPage() {
        MultiStatePage.register(LottieWaitingState())
        multiState = viewBinding.content.multiState {
            loadData()
        }
        loadData()
    }

    private fun loadData() {
        lifecycleScope.launchWhenCreated {
            try {
                multiState.show<LottieWaitingState>()
                val request =
                    Request.Builder().url("https://wanandroid.com/wxarticle/chapters/json").build()
                val okHttpClient = OkHttpClient.Builder().build()
                val call = okHttpClient.newCall(request)
                val response = withContext(Dispatchers.IO) { call.execute().body()?.string() }
                multiState.show<SuccessState>()
                viewBinding.content.text = response
            } catch (e: Exception) {
                e.printStackTrace()
                multiState.show<ErrorState> {
                    //可以直接设置 state 中的变量 刷新state
                    it.errorMsg = e.message.toString()
                }
            }
        }
    }
}