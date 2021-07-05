package com.zy.demo.base

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.zy.multistatepage.MultiState
import com.zy.multistatepage.MultiStateContainer
import java.lang.reflect.ParameterizedType

/**
 * @ProjectName: MultiStatePage
 * @Author: 赵岩
 * @Email: 17635289240@163.com
 * @Description: TODO
 * @CreateDate: 2020/10/23 10:45
 */
abstract class MultiStateBinding<VB : ViewBinding> : MultiState() {

    lateinit var viewBinding: VB

    override fun onCreateMultiStateView(
        context: Context,
        inflater: LayoutInflater,
        container: MultiStateContainer
    ): View {
        val parameterizedType = javaClass.genericSuperclass as ParameterizedType
        val clazz = parameterizedType.actualTypeArguments[0] as Class<*>
        val inflate = clazz.getDeclaredMethod(
            "inflate",
            LayoutInflater::class.java,
            ViewGroup::class.java,
            Boolean::class.java
        )
        viewBinding = inflate.invoke(null, inflate, container, false) as VB
        return viewBinding.root
    }

    override fun onMultiStateViewCreate(view: View) {
        onMultiStateViewCreate()
    }

    abstract fun onMultiStateViewCreate()
}