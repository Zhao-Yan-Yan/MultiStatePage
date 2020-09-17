package com.zy.multistatepage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.zy.multistatepage.base.BaseActivity
import com.zy.multistatepage.databinding.ActivityViewPager2Binding

class ViewPager2Activity : BaseActivity<ActivityViewPager2Binding>() {

    override fun initPage() {
        viewBinding.viewpager2.offscreenPageLimit = 5
        viewBinding.viewpager2.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int = 5

            override fun createFragment(position: Int): Fragment = if (position % 2 == 0) {
                MultiStateFragment.newInstance()
            } else {
                GlobalMultiFragment.newInstance()
            }
        }
    }
}