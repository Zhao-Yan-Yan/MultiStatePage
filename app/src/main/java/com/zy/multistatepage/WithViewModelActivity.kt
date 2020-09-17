package com.zy.multistatepage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.zy.multistatepage.base.BaseActivityVBVM
import com.zy.multistatepage.databinding.ActivityWithViewModelBinding

class WithViewModelActivity : BaseActivityVBVM<ActivityWithViewModelBinding, TestViewModel>() {
    override fun initPage() {
        viewModel.testRequest()
    }

    override fun registerObserver() {
        super.registerObserver()
        viewModel.response.observe(this, {
            Glide.with(this).load(it.imagePath).into(viewBinding.img)
        })
    }

    override fun reload() {
        super.reload()
        viewModel.testRequest()
    }
}