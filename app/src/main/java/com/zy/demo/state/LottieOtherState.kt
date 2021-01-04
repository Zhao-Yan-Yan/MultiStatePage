package com.zy.demo.state

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import com.zy.demo.R
import com.zy.multistatepage.MultiState
import com.zy.multistatepage.MultiStateContainer

/**
 * @ProjectName: MultiStatePage
 * @Author: 赵岩
 * @Email: 17635289240@163.com
 * @Description: TODO
 * @CreateDate: 2020/9/17 16:58
 */
class LottieOtherState : MultiState() {
    var retry: (() -> Unit)? = null
    override fun onCreateMultiStateView(
        context: Context,
        inflater: LayoutInflater,
        container: MultiStateContainer
    ): View {
        return inflater.inflate(R.layout.multi_lottie_other, container, false)
    }

    override fun onMultiStateViewCreate(view: View) {
        view.findViewById<View>(R.id.animation).setOnClickListener {
            retry?.invoke()
        }
    }
}