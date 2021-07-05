package com.zy.multistatepage

import android.app.Activity
import android.view.View
import android.view.ViewGroup

/**
 * @ProjectName: MultiStatePage
 * @Author: 赵岩
 * @Email: 17635289240@163.com
 * @Description: TODO
 * @CreateDate: 2020/9/17 11:53
 */
object MultiStatePage {

    /**
     * 实现原理
     * 1.根据目标view在父view中的位置索引,移除原目标view,
     * 2.将MultiStateContainer添加到原view的索引处
     * 3.MultiStateContainer 的 layoutParams 是原目标View的 layoutParams
     */
    @JvmStatic
    @JvmOverloads
    fun bindMultiState(
        targetView: View,
    ): MultiStateContainer {
        val parent = targetView.parent as ViewGroup?
        var targetViewIndex = 0
        val multiStateContainer = MultiStateContainer(targetView.context, targetView)
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
        multiStateContainer.initialization()
        return multiStateContainer
    }

    /**
     * 实现原理
     * 1. android.R.id.content 是Activity setContentView 内容的父view
     * 2. 在这个view中移除原本要添加的contentView
     * 3. 将MultiStateContainer设置为 content的子View  MultiStateContainer中持有原有的Activity setContentView
     */
    @JvmStatic
    @JvmOverloads
    fun bindMultiState(
        activity: Activity,
    ): MultiStateContainer {
        val targetView = activity.findViewById<ViewGroup>(android.R.id.content)
        val targetViewIndex = 0
        val oldContent: View = targetView.getChildAt(targetViewIndex)
        targetView.removeView(oldContent)
        val oldLayoutParams = oldContent.layoutParams
        val multiStateContainer = MultiStateContainer(oldContent.context, oldContent)
        targetView.addView(multiStateContainer, targetViewIndex, oldLayoutParams)
        multiStateContainer.initialization()
        return multiStateContainer
    }

    var config: MultiStateConfig = MultiStateConfig()

    @JvmStatic
    fun config(config: MultiStateConfig): MultiStatePage {
        this.config = config
        return this
    }

}