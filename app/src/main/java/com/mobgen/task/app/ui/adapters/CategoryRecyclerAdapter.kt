package com.mobgen.task.app.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobgen.task.R
import com.mobgen.task.data.network.model.CategoryData
import kotlinx.android.synthetic.main.item_category.view.*

class CategoryRecyclerAdapter(
    private val categories: List<CategoryData>
): RecyclerView.Adapter<CategoryRecyclerAdapter.ItemViewHolder>() {

    var callback : CategoryClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
            R.layout.item_category, parent, false)
        )
    }

    override fun getItemCount(): Int = categories.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val category = categories[position]
        holder.bind(category, position)
    }

    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: CategoryData, position: Int) {
            itemView.tv_home_title.text = item.categoryName
            itemView.tv_home_subtitle.text = item.type.toString()
            itemView.setOnClickListener {
                callback?.onItemClicked(item)
            }
        }
    }

    interface CategoryClickListener{
        fun onItemClicked(item: CategoryData)
    }
}