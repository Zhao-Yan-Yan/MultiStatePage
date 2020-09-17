package com.zy.multistatepage

import android.view.View

/**
 * @ProjectName: MultiStatePage
 * @Author: 赵岩
 * @Email: 17635289240@163.com
 * @Description: TODO
 * @CreateDate: 2020/9/17 17:10
 */
fun View.multiState(retryListener: () -> Unit = {}) = MultiStatePage.multiState(this, retryListener)
