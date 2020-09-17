package com.zy.multistatepage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.zy.multistatepage.base.BaseActivity
import com.zy.multistatepage.base.mock
import com.zy.multistatepage.databinding.ActivityRecyclerViewBinding
import com.zy.multistatepage.databinding.ItemBinding

class RecyclerViewActivity : BaseActivity<ActivityRecyclerViewBinding>() {
    override fun initPage() {
        viewBinding.rlv.layoutManager = LinearLayoutManager(this)
        viewBinding.rlv.adapter = object : RecyclerView.Adapter<Holder>() {

            override fun getItemCount(): Int = 20
            override fun onBindViewHolder(holder: Holder, position: Int) {
                val multiState = holder.viewBinding.content.multiState()
                mock(multiState)
            }

            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder = Holder(
                ItemBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )

        }
    }

    inner class Holder(val viewBinding: ItemBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

    }
}