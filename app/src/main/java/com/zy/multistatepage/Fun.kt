package com.zy.multistatepage

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
fun mock(multiStateContainer: MultiStateContainer,callBack: () -> Unit = {}) {
    MainScope().launch {
        multiStateContainer.showLoading()
        val delayTime = (10..30).random() * 100.toLong()
        delay(delayTime)
        when ((1..3).random()) {
            1 -> multiStateContainer.showSuccess(callBack)
            2 -> multiStateContainer.showEmpty(callBack)
            3 -> multiStateContainer.showError(callBack)
        }
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