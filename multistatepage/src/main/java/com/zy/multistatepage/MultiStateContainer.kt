package com.zy.multistatepage

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import com.zy.multistatepage.state.SuccessState

/**
 * @ProjectName: MultiStatePage
 * @Author: 赵岩
 * @Email: 17635289240@163.com
 * @Description: TODO
 * @CreateDate: 2020/9/17 11:54
 */
@SuppressLint("ViewConstructor")
class MultiStateContainer(
    context: Context,
    val originTargetView: View,
    val retryListener: () -> Unit
) : FrameLayout(context) {
    var successAnimator: ObjectAnimator? = null
    var stateChangeAnimator: ObjectAnimator? = null
    inline fun <reified T : MultiState> show(notify: (T) -> Unit = {}) {
        MultiStatePage.getDefault()[T::class.java]?.let { multiState ->
            removeAllViews()
            if (multiState is SuccessState) {
                addView(originTargetView)
                if (successAnimator == null) {
                    successAnimator = ObjectAnimator.ofFloat(originTargetView, "alpha", 0.0f, 1.0f).apply {
                        duration = 300
                    }
                }
                successAnimator?.start()
                return@let
            } else if (multiState.layoutId() != 0) {
                val view = View.inflate(context, multiState.layoutId(), null)
                if (multiState.enableReload()) {
                    view.setOnClickListener {
                        retryListener.invoke()
                    }
                }
                addView(view)
                if (stateChangeAnimator == null) {
                    stateChangeAnimator = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f).apply {
                        duration = 300
                    }
                }
                stateChangeAnimator?.start()
                notify.invoke(multiState as T)
                multiState.onMultiStateCreate(view)
                return@let
            }
        }
    }

}