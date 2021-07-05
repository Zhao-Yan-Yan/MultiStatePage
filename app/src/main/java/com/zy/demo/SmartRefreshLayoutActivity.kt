package com.zy.demo

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zy.demo.base.*
import com.zy.demo.databinding.ActivitySmartRefreshLayoutBinding
import com.zy.demo.databinding.RlvItemBinding
import kotlinx.android.synthetic.main.multi_lottie_other.*
import kotlinx.coroutines.delay

/**
 * @ProjectName: MultiStatePage
 * @Author: 赵岩
 * @Email: 17635289240@163.com
 * @Description: TODO
 * @CreateDate: 2021/2/9 14:33
 */
class SmartRefreshLayoutActivity : BaseActivity<ActivitySmartRefreshLayoutBinding>() {

    private val rlvAdapter = RlvAdapter()

    override fun initPage() {
        viewBinding.recyclerView.layoutManager = LinearLayoutManager(this)
        viewBinding.recyclerView.adapter = rlvAdapter
        loadData()

        viewBinding.smartRefreshLayout.setEnableLoadMoreWhenContentNotFull(false)

        viewBinding.smartRefreshLayout.setOnRefreshListener {
            rlvAdapter.refreshData(getData(50))
            viewBinding.container.showSuccess()
            it.finishRefresh()
        }
        viewBinding.smartRefreshLayout.setOnLoadMoreListener {
            rlvAdapter.addData(getData(30))
            viewBinding.container.showSuccess()
            it.finishLoadMore()
        }

        viewBinding.btnContent.setOnClickListener {
            rlvAdapter.refreshData(getData(50))
            viewBinding.container.showSuccess()
        }
        viewBinding.btnError.setOnClickListener {
            rlvAdapter.clearData()
            viewBinding.container.showError() {
                it.retry { loadData() }
            }
        }
        viewBinding.btnEmpty.setOnClickListener {
            rlvAdapter.clearData()
            viewBinding.container.showEmpty()
        }
    }

    private fun loadData() {
        lifecycleScope.launchWhenResumed {
            viewBinding.container.showLoading()
            delay(3000)
            rlvAdapter.refreshData(getData(50))
            viewBinding.container.showSuccess()
        }
    }

    private fun getData(count: Int): MutableList<String> {
        val data = mutableListOf<String>()
        for (i in 0 until count) {
            data.add("data")
        }
        return data
    }

    inner class RlvAdapter : RecyclerView.Adapter<RlvAdapter.Holder>() {

        var data = mutableListOf<String>()

        inner class Holder(val viewBinding: RlvItemBinding) : RecyclerView.ViewHolder(viewBinding.root)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder =
            Holder(RlvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

        @SuppressLint("SetTextI18n")
        override fun onBindViewHolder(holder: Holder, position: Int) {
            holder.viewBinding.root.text = "${data[position]}${position}"
        }

        override fun getItemCount(): Int = data.size

        fun addData(data: MutableList<String>) {
            this.data.addAll(data)
            notifyDataSetChanged()
        }

        fun refreshData(data: MutableList<String>) {
            this.data = data
            notifyDataSetChanged()
        }

        fun clearData() {
            this.data.clear()
            notifyDataSetChanged()
        }
    }
}