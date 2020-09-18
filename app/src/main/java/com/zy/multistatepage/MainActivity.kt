package com.zy.multistatepage

import com.zy.multistatepage.base.BaseActivity
import com.zy.multistatepage.base.startActivity
import com.zy.multistatepage.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun initPage() {
        //Activity 中使用
        viewBinding.btnActivity.setOnClickListener {
            startActivity<MultiStateActivity>()
        }
        //Fragment中使用
        viewBinding.btnFragment.setOnClickListener {
            startActivity<MultiFragmentActivity>()
        }
        //同时处理多个View
        viewBinding.btnView.setOnClickListener {
            startActivity<MultiViewActivity>()
        }
        //ViewPager2中使用
        viewBinding.btnViewpager2.setOnClickListener {
            startActivity<ViewPager2Activity>()
        }
        //State 拓展
        viewBinding.btnLottie.setOnClickListener {
            startActivity<LottieExtActivity>()
        }
        //结合网络请求
        viewBinding.btnNet.setOnClickListener {
            startActivity<MockNetActivity>()
        }
    }
}