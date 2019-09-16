package com.crazyma.itemshownsample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*

/**
 * @author Batu
 */
class ListAdapter(var items: List<Item>? = null) : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder.create(parent)
    }

    override fun getItemCount() = items?.size ?: 0

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(items!![position])
    }

    class Item(val id: Int, val title: String)

    class ListViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        companion object {
            fun create(parent: ViewGroup) =
                ListViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.list_item, parent, false)
                )
        }

        fun bind(item: Item) {
            itemView.apply {
                idTextView.text = "ID: ${item.id}"
                titleTextView.text = item.title
            }
        }
    }
}