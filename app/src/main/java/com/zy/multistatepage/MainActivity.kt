package com.zy.multistatepage

import android.content.Intent
import com.zy.multistatepage.base.BaseActivity
import com.zy.multistatepage.base.startActivity
import com.zy.multistatepage.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun initPage() {
        viewBinding.btnActivity.setOnClickListener {
            startActivity<MultiStateActivity>()
        }

        viewBinding.btnFragment.setOnClickListener {
            startActivity<MultiFragmentActivity>()
        }

        viewBinding.btnViewpager2.setOnClickListener {
            startActivity<ViewPager2Activity>()
        }
        viewBinding.btnLottie.setOnClickListener {
            startActivity<LottieExtActivity>()
        }
        viewBinding.btnNet.setOnClickListener {
            startActivity<MockNetActivity>()
        }
    }
}