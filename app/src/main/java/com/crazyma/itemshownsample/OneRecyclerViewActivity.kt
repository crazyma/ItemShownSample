package com.crazyma.itemshownsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_one_recyclerview.*

/**
 * @author Batu
 */
class OneRecyclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one_recyclerview)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {


        val items = mutableListOf<ListAdapter.Item>()

        for (i in 0..20) {
            ListAdapter.Item(i, (Math.random() * 1000).toString()).let { items.add(it) }
        }

        val adapter = ListAdapter(items)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

}