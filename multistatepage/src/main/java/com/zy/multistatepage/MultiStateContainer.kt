package com.zy.multistatepage

import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.zy.multistatepage.state.SuccessState

/**
 * @ProjectName: MultiStatePage
 * @Author: 赵岩
 * @Email: 17635289240@163.com
 * @Description: TODO
 * @CreateDate: 2020/9/17 11:54
 */
@Suppress("UNCHECKED_CAST")
class MultiStateContainer : FrameLayout {

    private var originTargetView: View? = null

    private var lastState: String = ""

    private var statePool: MutableMap<Class<out MultiState>, MultiState> = mutableMapOf()

    private var animator = ValueAnimator.ofFloat(0.0f, 1.0f).apply {
        duration = MultiStatePage.config.alphaDuration
    }

    constructor(
        context: Context,
        originTargetView: View,
    ) : this(context, null) {
        this.originTargetView = originTargetView
    }

    constructor(
        context: Context,
        attrs: AttributeSet?
    ) : this(context, attrs, 0)

    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int
    ) : super(context, attrs, defStyleAttr)

    override fun onFinishInflate() {
        super.onFinishInflate()
        if (originTargetView == null && childCount == 1) {
            originTargetView = getChildAt(0)
        }
    }

    fun initialization() {
        val layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        addView(originTargetView, 0, layoutParams)
        // MultiStatePage.config?.defaultState?.let { show(it) }
    }

    inline fun <reified T : MultiState> show(enableAnimator: Boolean = true, noinline notify: (T) -> Unit = {}) {
        show(T::class.java, enableAnimator, notify)
    }

    @JvmOverloads
    fun <T : MultiState> show(
        multiState: T,
        enableAnimator: Boolean = true,
        onNotifyListener: OnNotifyListener<T>? = null
    ) {
        if (childCount == 0) {
            initialization()
        }
        if (childCount > 1) {
            removeViewAt(1)
        }
        if (multiState is SuccessState) {
            //如果上次展示的是SuccessState则跳过
            if (lastState != SuccessState::class.java.name) {
                originTargetView?.visibility = View.VISIBLE
                if (enableAnimator) originTargetView?.executeAnimator()
            }
        } else {
            originTargetView?.visibility = View.INVISIBLE
            val currentStateView = multiState.onCreateMultiStateView(context, LayoutInflater.from(context), this)
            multiState.onMultiStateViewCreate(currentStateView)
            addView(currentStateView)
            if (enableAnimator) currentStateView.executeAnimator()
            onNotifyListener?.onNotify(multiState)
        }
        //记录上次展示的state
        lastState = multiState.javaClass.name
    }

    @JvmOverloads
    fun <T : MultiState> show(
        clazz: Class<T>,
        enableAnimator: Boolean = true,
        onNotifyListener: OnNotifyListener<T>? = null
    ) {
        findState(clazz)?.let { multiState -> show(multiState as T, enableAnimator, onNotifyListener) }
    }

    private fun <T : MultiState> findState(clazz: Class<T>): MultiState? {
        return if (statePool.containsKey(clazz)) {
            statePool[clazz]
        } else {
            val state = clazz.newInstance()
            statePool[clazz] = state
            state
        }
    }

    private fun View.executeAnimator() {
        this.clearAnimation()
        animator.addUpdateListener {
            this.alpha = it.animatedValue as Float
        }
        animator.start()
    }
}