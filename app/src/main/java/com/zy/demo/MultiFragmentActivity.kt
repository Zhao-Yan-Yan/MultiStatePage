package com.zy.demo

import com.zy.demo.base.BaseActivity
import com.zy.demo.databinding.ActivityMultiFragmentBinding

class MultiFragmentActivity : BaseActivity<ActivityMultiFragmentBinding>() {

    override fun initPage() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fl, MultiStateFragment.newInstance())
            .commit()
    }
}