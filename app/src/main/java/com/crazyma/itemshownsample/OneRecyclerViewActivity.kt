package com.crazyma.itemshownsample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_one_recyclerview.*

/**
 * @author Batu
 */
class OneRecyclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_one_recyclerview)
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

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val firstVisible = (recyclerView.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
                val lastVisible = (recyclerView.layoutManager as LinearLayoutManager).findLastVisibleItemPosition()

                val firstItem = items[firstVisible].toString()
                val lastItem = items[lastVisible].toString()

                Log.d("badu", "first: $firstItem, last: $lastItem")
            }
        })
    }

}