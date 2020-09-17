package com.zy.multistatepage.base

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.zy.multistatepage.MultiStateContainer
import com.zy.multistatepage.multiStateActivityRoot
import com.zy.multistatepage.state.EmptyState
import com.zy.multistatepage.state.ErrorState
import com.zy.multistatepage.state.LottieOtherState
import com.zy.multistatepage.state.SuccessState
import java.lang.reflect.ParameterizedType

abstract class BaseActivityVBVM<VB : ViewBinding, VM : BaseViewModel> : BaseActivity<VB>() {
    lateinit var viewModel: VM
    lateinit var multiStateActivityRoot: MultiStateContainer
    override fun onCreate(savedInstanceState: Bundle?) {
        viewModel = createViewModel()
        super.onCreate(savedInstanceState)
        registerObserver()
        multiStateActivityRoot = multiStateActivityRoot { reload() }
    }

    open fun reload() {}
    open fun registerObserver() {
        viewModel.pageStateChange.showContent.observe(this, Observer {
            multiStateActivityRoot.show<SuccessState>()
        })
        viewModel.pageStateChange.showEmpty.observe(this, Observer {
            multiStateActivityRoot.show<EmptyState>()
        })
        viewModel.pageStateChange.showError.observe(this, Observer {errorStr->
            multiStateActivityRoot.show<ErrorState>{
                it.errorMsg = errorStr
            }
        })
        viewModel.pageStateChange.showLoading.observe(this, Observer {
            multiStateActivityRoot.show<LottieOtherState>()
        })
    }

    open fun createViewModel(): VM = ViewModelProvider(
        this, ViewModelProvider.AndroidViewModelFactory(application)
    ).get(getVmClazz(this))

    @Suppress("UNCHECKED_CAST")
    fun <VM> getVmClazz(obj: Any): VM {
        val type = obj.javaClass.genericSuperclass as ParameterizedType
        return type.actualTypeArguments[1] as VM
    }
}