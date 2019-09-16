package com.crazyma.itemshownsample

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.layout_collapsed_view_pager.*
import kotlinx.android.synthetic.main.layout_collapsed_view_pager.appBarLayout
import kotlinx.android.synthetic.main.layout_collapsed_view_pager.tabLayout
import kotlinx.android.synthetic.main.layout_collapsed_view_pager.viewPager

/**
 * @author Batu
 */
class CollapsedPagerActivity : AppCompatActivity(), TestFragment.Callback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_collapsed_view_pager)

        setupAppBarLayout()
        setupViewPager()
        getContentViewSize()
    }

    override fun registerAppBarLayoutOffsetListener(listener: AppBarLayout.OnOffsetChangedListener) {
        appBarLayout.addOnOffsetChangedListener(listener)
    }

    override fun unregisterAppBarLayoutOffsetListener(listener: AppBarLayout.OnOffsetChangedListener) {
        appBarLayout.removeOnOffsetChangedListener(listener)
    }

    private fun setupAppBarLayout() {
//        appBarLayout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
//            Log.d("badu", "verticalOffset: $verticalOffset")
//        })
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

    private fun getContentViewSize(){
        Handler().postDelayed({

            val resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android")
            val navigationBarHeight = if (resourceId > 0) {
                resources.getDimensionPixelSize(resourceId)
            } else 0


            val contentView = this@CollapsedPagerActivity.findViewById<View>(android.R.id.content)
            Log.v("badu", "navigationBarHeight : $navigationBarHeight")
            Log.v("badu", "content view height : ${contentView.height}")
        },3000)
    }

}