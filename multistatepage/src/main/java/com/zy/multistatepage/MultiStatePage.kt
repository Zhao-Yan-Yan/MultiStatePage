package com.zy.multistatepage

import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import com.zy.multistatepage.state.EmptyState
import com.zy.multistatepage.state.ErrorState
import com.zy.multistatepage.state.LoadingState
import com.zy.multistatepage.state.SuccessState

/**
 * @ProjectName: MultiStatePage
 * @Author: 赵岩
 * @Email: 17635289240@163.com
 * @Description: TODO
 * @CreateDate: 2020/9/17 11:53
 */
object MultiStatePage {
    private var statePoll: MutableMap<Class<out MultiState>, MultiState> = mutableMapOf()

    init {
        register(SuccessState())
        register(EmptyState())
        register(ErrorState())
        register(LoadingState())
    }

    fun register(multiState: MultiState): MultiStatePage {
        if (!statePoll.containsKey(multiState::class.java)) {
            statePoll[multiState::class.java] = multiState
        }
        return this
    }

    fun getDefault(): MutableMap<Class<out MultiState>, MultiState> = statePoll

    fun multiState(targetView: View, retryListener: () -> Unit = {}): MultiStateContainer {
        val parent = targetView.parent as ViewGroup?
        var targetViewIndex = 0
        val multiStateContainer = MultiStateContainer(targetView.context, targetView, retryListener)
        parent?.let { targetViewParent ->
            for (i in 0 until targetViewParent.childCount) {
                if (targetViewParent.getChildAt(i) == targetView) {
                    targetViewIndex = i
                    break
                }
            }
            targetViewParent.removeView(targetView)
            targetViewParent.addView(multiStateContainer, targetViewIndex, targetView.layoutParams)
        }
        multiStateContainer.show<SuccessState>()
        return multiStateContainer
    }
}