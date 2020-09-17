package com.zy.multistatepage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zy.multistatepage.base.BaseActivity
import com.zy.multistatepage.databinding.ActivityMultiFragmentBinding
import com.zy.multistatepage.databinding.ActivityMultiStateBinding

class MultiFragmentActivity : BaseActivity<ActivityMultiFragmentBinding>() {

    override fun initPage() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fl, MultiStateFragment.newInstance())
            .commit()
    }
}