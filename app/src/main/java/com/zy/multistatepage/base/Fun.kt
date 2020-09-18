package com.zy.multistatepage.base

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.zy.multistatepage.MultiStateContainer
import com.zy.multistatepage.state.EmptyState
import com.zy.multistatepage.state.ErrorState
import com.zy.multistatepage.state.LoadingState
import com.zy.multistatepage.state.SuccessState
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * @ProjectName: MultiStatePage
 * @Author: 赵岩
 * @Email: 17635289240@163.com
 * @Description: TODO
 * @CreateDate: 2020/9/17 15:04
 */
fun mockRandom(multiStateContainer: MultiStateContainer) {
    MainScope().launch {
        multiStateContainer.show<LoadingState>()
        val delayTime = (10..30).random() * 100.toLong()
        delay(delayTime)
        when ((1..3).random()) {
            1 -> multiStateContainer.show<SuccessState>()
            2 -> multiStateContainer.show<EmptyState>()
            3 -> multiStateContainer.show<ErrorState>()
        }
    }
}

fun mockError(multiStateContainer: MultiStateContainer) {
    MainScope().launch {
        multiStateContainer.show<LoadingState>()
        val delayTime = (10..30).random() * 100.toLong()
        delay(delayTime)
        multiStateContainer.show<ErrorState>()
    }
}

fun mockSuccess(multiStateContainer: MultiStateContainer) {
    MainScope().launch {
        multiStateContainer.show<LoadingState>()
        val delayTime = (10..30).random() * 100.toLong()
        delay(delayTime)
        multiStateContainer.show<SuccessState>()
    }
}

fun mockEmpty(multiStateContainer: MultiStateContainer) {
    MainScope().launch {
        multiStateContainer.show<LoadingState>()
        val delayTime = (10..30).random() * 100.toLong()
        delay(delayTime)
        multiStateContainer.show<EmptyState>()
    }
}

fun MultiStateContainer.showSuccess(callBack: () -> Unit = {}) {
    show<SuccessState> {
        callBack.invoke()
    }
}

fun MultiStateContainer.showError(callBack: () -> Unit = {}) {
    show<ErrorState> {
        callBack.invoke()
    }
}

fun MultiStateContainer.showEmpty(callBack: () -> Unit = {}) {
    show<EmptyState> {
        callBack.invoke()
    }
}

fun MultiStateContainer.showLoading(callBack: () -> Unit = {}) {
    show<LoadingState> {
        callBack.invoke()
    }
}

inline fun <reified T : Activity> Activity.startActivity() {
    startActivity(Intent(this, T::class.java))
}