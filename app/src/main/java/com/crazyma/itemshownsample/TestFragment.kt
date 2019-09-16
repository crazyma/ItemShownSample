package com.crazyma.itemshownsample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.layout_one_recyclerview.*

/**
 * @author Batu
 */
class TestFragment : Fragment() {

    companion object {
        fun newInstance() = TestFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_one_recyclerview, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewPager()
    }

    private fun setupViewPager() {
        val items = mutableListOf<ListAdapter.Item>()

        for (i in 0..20) {
            ListAdapter.Item(i, (Math.random() * 1000).toString()).let { items.add(it) }
        }

        val adapter = ListAdapter(items)
        recyclerView.layoutManager = LinearLayoutManager(context!!)
        recyclerView.adapter = adapter
    }

}