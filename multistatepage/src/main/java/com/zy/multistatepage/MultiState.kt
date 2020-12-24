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

    /**
     * 创建stateView
     */
    abstract fun onCreateMultiStateView(
        context: Context,
        inflater: LayoutInflater,
        container: MultiStateContainer
    ): View

    /**
     * stateView创建完成
     */
    abstract fun onMultiStateViewCreate(view: View)

    /**
     * 是否允许重新加载 点击事件
     * 默认false 不允许
     */
    open fun enableReload(): Boolean = false

    /**
     * 绑定重试view
     * 默认null为整个state view
     */
    open fun bindRetryView(): View? = null

    /**
     * dialog 模式
     */
    open fun dialogMode(): Boolean = false
}