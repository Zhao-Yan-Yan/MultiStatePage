package com.zy.multistatepage

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
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
    val retryListener: (multiStateContainer: MultiStateContainer) -> Unit
) : FrameLayout(context) {

    var animator = ValueAnimator.ofFloat(0.0f, 1.0f).apply {
        duration = 500
    }

    inline fun <reified T : MultiState> show(notify: (T) -> Unit = {}) {
        MultiStatePage.getDefault()[T::class.java]?.let { multiState ->
            removeAllViews()
            multiState.onDestroy()
            if (multiState is SuccessState) {
                addView(originTargetView)
                originTargetView.doAnimator()
            } else if (multiState.layoutId() != 0) {
                val view = View.inflate(context, multiState.layoutId(), null)
                if (multiState.enableReload()) {
                    view.setOnClickListener {
                        retryListener.invoke(this)
                    }
                }
                addView(view)
                view.doAnimator()
                notify.invoke(multiState as T)
                multiState.onMultiStateCreate(view)
            }
        }
    }

    fun View.doAnimator() {
        this.clearAnimation()
        animator.addUpdateListener {
            this.alpha = it.animatedValue as Float
        }
        animator.start()
    }

}