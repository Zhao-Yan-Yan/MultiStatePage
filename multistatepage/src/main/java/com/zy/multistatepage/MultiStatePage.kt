package com.zy.multistatepage

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.core.view.marginBottom
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

    @JvmStatic
    fun register(vararg multiState: MultiState): MultiStatePage {
        multiState.forEach {
            if (!statePoll.containsKey(it::class.java)) {
                statePoll[it::class.java] = it
            }
        }
        return this
    }

    @JvmStatic
    fun unRegister(multiState: MultiState) {
        if (statePoll.containsKey(multiState::class.java)) {
            statePoll.remove(multiState::class.java)
        }
    }

    @JvmStatic
    fun getDefault(): MutableMap<Class<out MultiState>, MultiState> = statePoll

    /**
     * 实现原理
     * 1.根据目标view在父view中的位置索引,移除原目标view,
     * 2.将MultiStateContainer添加到原view的索引处
     * 3.MultiStateContainer 的 layoutParams 是原目标View的 layoutParams
     */
    @JvmStatic
    fun multiState(
        targetView: View,
        retryListener: (multiStateContainer: MultiStateContainer) -> Unit = {}
    ): MultiStateContainer {
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
            val targetViewLayoutParams = targetView.layoutParams
            val temp = targetView.layoutParams
            targetViewParent.addView(multiStateContainer, targetViewIndex, temp)

        }
        multiStateContainer.show<SuccessState>()
        return multiStateContainer
    }

    /**
     * 实现原理
     * 1. android.R.id.content 是Activity setContentView 内容的父view
     * 2. 在这个view中移除原本要添加的contentView
     * 3. 将MultiStateContainer设置为 content的子View  MultiStateContainer中持有原有的Activity setContentView
     */
    @JvmStatic
    fun multiStateActivity(
        activity: Activity,
        retryListener: (multiStateContainer: MultiStateContainer) -> Unit = {}
    ): MultiStateContainer {
        val targetView = activity.findViewById<ViewGroup>(android.R.id.content)
        val targetViewIndex = 0
        val oldContent: View = targetView.getChildAt(targetViewIndex)
        targetView.removeView(oldContent)
        val oldLayoutParams = oldContent.layoutParams
        val multiStateContainer = MultiStateContainer(oldContent.context, oldContent, retryListener)
        targetView.addView(multiStateContainer, targetViewIndex, oldLayoutParams)
        multiStateContainer.show<SuccessState>()
        return multiStateContainer
    }

    @JvmStatic
    fun config(config: Config): MultiStatePage {
        return this
    }
}