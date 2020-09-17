package com.zy.multistatepage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import com.zy.multistatepage.base.BaseActivity
import com.zy.multistatepage.base.mock
import com.zy.multistatepage.databinding.ActivityGlobalMultiBinding

class GlobalMultiActivity : BaseActivity<ActivityGlobalMultiBinding>() {
    override fun initPage() {
        val multiState =// findViewById<ViewGroup>(android.R.id.content).multiState()
            MultiStatePage.multiStateActivity(this)
        mock(multiState)
    }
}