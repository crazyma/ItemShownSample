package com.crazyma.itemshownsample

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

/**
 * @author Batu
 */
class CustomPagerAdapter(
    fm: FragmentManager,
    _items: List<Item>
) : DcardFragmentPagerAdapter(fm) {

    class Item(val type: Int, val title: String)

    var items = _items

    override fun getItem(position: Int): Fragment {
        return when (val type = items[position].type) {
            0 -> {
                TestFragment.newInstance()
            }
            else -> {
                throw IllegalArgumentException("Unknown Fragment in CustomPagerAdapter")
            }
        }
    }

    override fun makeFragmentName(id: Long): String {
        return items[id.toInt()].title.replace(" ", "_")
    }

    override fun getCount() = items.size

    override fun getPageTitle(position: Int) = items[position].title
}