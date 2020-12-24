package com.zy.demo

import com.zy.demo.databinding.ActivityMainBinding
import com.zy.demo.base.BaseActivity
import com.zy.demo.base.startActivity

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
        viewBinding.btnApi.setOnClickListener {
            startActivity<ApiActivity>()
        }
        //State 刷新
        viewBinding.btnRefresh.setOnClickListener {
            startActivity<RefreshStateActivity>()
        }
        //结合网络请求
        viewBinding.btnNet.setOnClickListener {
            startActivity<MockNetActivity>()
        }
    }
}