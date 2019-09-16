package com.crazyma.itemshownsample

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.layout_one_recyclerview.*

/**
 * @author Batu
 */
class TestFragment : Fragment(),
AppBarLayout.OnOffsetChangedListener{

    companion object {
        fun newInstance() = TestFragment()
    }

    interface Callback{
        fun registerAppBarLayoutOffsetListener(listener: AppBarLayout.OnOffsetChangedListener)
        fun unregisterAppBarLayoutOffsetListener(listener: AppBarLayout.OnOffsetChangedListener)
    }

    private var adapter: ListAdapter? = null

    //  TODO by Batu: could be a 'lateinit val'
    private var callback: Callback? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is Callback){
            callback = context
        }else if(parentFragment != null && parentFragment is Callback){
            callback = parentFragment as Callback
        }else{
            //  TODO by Batu: need th throw a exception
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("badu", "onCreate | $this")
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
        val contentView = view.findViewById<View?>(android.R.id.content)
        Log.w("badu","view : $contentView")
        view.parent
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
        callback?.registerAppBarLayoutOffsetListener(this)
    }

    override fun onPause() {
        super.onPause()
        callback?.unregisterAppBarLayoutOffsetListener(this)
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

    // AppBarLayout Listener
    override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
        checkVisibleItems()
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
                val screenHeight = resources.displayMetrics.heightPixels
                var finalLastIndex = firstVisible
                for(index in lastVisible downTo firstVisible ) {
                    val lastView = (recyclerView.layoutManager as LinearLayoutManager)
                        .findViewByPosition(index)
                    val lastPosition = IntArray(2)
                    lastView?.getLocationInWindow(lastPosition)

                    if(lastPosition[1] <= screenHeight){
                        finalLastIndex = index
                        break
                    }
                }

                Log.d("badu","visible range: $firstVisible ~ $finalLastIndex")
            } else {
                Log.d("badu", "no position")
            }
        }
    }

}