package com.crazyma.itemshownsample

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_one_recyclerview.*

/**
 * @author Batu
 */
class TestFragment : Fragment() {

    companion object {
        fun newInstance() = TestFragment()
    }

    private var adapter: ListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("badu", "onCreate | $this")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i("badu", "onCreateView | $this")
        return inflater.inflate(R.layout.layout_one_recyclerview, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewPager()
    }

    override fun onStart() {
        super.onStart()
        Log.i("badu", "onStart | $this")
    }

    override fun onResume() {
        super.onResume()
        Log.i("badu", "onResume | $this")
        checkVisibleItems()
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                checkVisibleItems()
            }
        })
    }

    override fun onPause() {
        super.onPause()
        Log.i("badu", "onPause | $this")
    }

    override fun onStop() {
        super.onStop()
        Log.i("badu", "onStop | $this")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("badu", "onDestroyView | $this")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("badu", "onDestroy | $this")
    }

    private fun setupViewPager() {
        val items = mutableListOf<ListAdapter.Item>()

        for (i in 0..20) {
            ListAdapter.Item(i, (Math.random() * 1000).toString()).let { items.add(it) }
        }

        val adapter = ListAdapter(items)
        this.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context!!)
        recyclerView.adapter = adapter
    }

    private fun checkVisibleItems() {
        if (!adapter?.items.isNullOrEmpty()) {
            val items = adapter?.items!!
            val firstVisible =
                (recyclerView.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
            val lastVisible =
                (recyclerView.layoutManager as LinearLayoutManager).findLastVisibleItemPosition()

            if (firstVisible != RecyclerView.NO_POSITION && lastVisible != RecyclerView.NO_POSITION) {
                val firstItem = items[firstVisible].toString()
                val lastItem = items[lastVisible].toString()

                Log.d("badu", "first: $firstItem, last: $lastItem")
            } else {
                Log.d("badu", "no position")
            }
        }
    }

}