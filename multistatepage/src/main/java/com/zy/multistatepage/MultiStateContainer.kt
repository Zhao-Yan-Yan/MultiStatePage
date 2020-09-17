package com.zy.multistatepage

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

    inline fun <reified T : MultiState> show(notify: (T) -> Unit = {}) {
        MultiStatePage.getDefault()[T::class.java]?.let { multiState ->
            removeAllViews()
            if (multiState is SuccessState) {
                addView(originTargetView)
            } else if (multiState.layoutId() != 0) {
                val view = View.inflate(context, multiState.layoutId(), null)
                if (multiState.enableReload()) {
                    view.setOnClickListener {
                        retryListener.invoke()
                    }
                }
                addView(view)
                notify.invoke(multiState as T)
                multiState.onMultiStateCreate(view)
            }
        }
    }

}