package com.zy.demo

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.zy.demo.base.BaseActivity
import com.zy.demo.databinding.ActivityViewPager2Binding

class ViewPager2Activity : BaseActivity<ActivityViewPager2Binding>() {

    override fun initPage() {
        viewBinding.viewpager2.offscreenPageLimit = 5
        viewBinding.viewpager2.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int = 5
            override fun createFragment(position: Int): Fragment = MultiStateFragment.newInstance()
        }
    }
}