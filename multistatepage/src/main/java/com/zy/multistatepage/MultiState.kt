package com.zy.multistatepage

import android.content.Context
import android.view.View

/**
 * @ProjectName: MultiStatePage
 * @Author: 赵岩
 * @Email: 17635289240@163.com
 * @Description: TODO
 * @CreateDate: 2020/9/17 12:01
 */
abstract class MultiState {
    abstract fun layoutId(): Int

    abstract fun onMultiStateCreate(view: View)

    abstract fun enableReload(): Boolean

}