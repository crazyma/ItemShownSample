package com.crazyma.itemshownsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.layout_view_pager.*

/**
 * @author Batu
 */
class PagerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_view_pager)
        setupViewPager()
    }

    private fun setupViewPager() {
        val items = mutableListOf<CustomPagerAdapter.Item>()
        for (i in 0..5) {
            CustomPagerAdapter.Item(0, "item ${i + 1}").let { items.add(it) }
        }
        viewPager.apply {
            val adapter = CustomPagerAdapter(
                supportFragmentManager,
                items
            )
            this.adapter = adapter

        }
        tabLayout.apply {
            setupWithViewPager(viewPager)
        }
    }

}