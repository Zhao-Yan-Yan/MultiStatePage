package com.zy.multistatepage

import android.content.Context
import android.view.LayoutInflater
import android.view.View

/**
 * @ProjectName: MultiStatePage
 * @Author: 赵岩
 * @Email: 17635289240@163.com
 * @Description: TODO
 * @CreateDate: 2020/9/17 12:01
 */
abstract class MultiState {
    abstract fun onCreateMultiStateView(context: Context, inflater: LayoutInflater,container: MultiStateContainer): View

    abstract fun onMultiStateViewCreate(view: View)

    abstract fun enableReload(): Boolean

    open fun retryView(): View? = null
}