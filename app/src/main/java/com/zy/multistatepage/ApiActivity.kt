package com.zy.multistatepage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.zy.multistatepage.base.BaseActivity
import com.zy.multistatepage.databinding.ActivityApiBinding

class ApiActivity : BaseActivity<ActivityApiBinding>() {
    override fun initPage() {
        Log.e("TAG", "a")
//        a()
    }

    inline fun a() {
        Log.e("TAG", "a")
    }
}