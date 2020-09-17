package com.zy.multistatepage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zy.multistatepage.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun initPage() {
        viewBinding.btnActivity.setOnClickListener {
            val intent = Intent(this, MultiStateActivity::class.java)
            startActivity(intent)
        }
        viewBinding.btnFragment.setOnClickListener {

        }
    }
}