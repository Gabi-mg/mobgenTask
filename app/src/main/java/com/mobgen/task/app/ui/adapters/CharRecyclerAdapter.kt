package com.mobgen.task.app.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobgen.task.R
import com.mobgen.task.data.network.model.CharData
import kotlinx.android.synthetic.main.item_char.view.*

class CharRecyclerAdapter(
    private val chars: List<CharData>
): RecyclerView.Adapter<CharRecyclerAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_char, parent, false)
        )
    }

    override fun getItemCount(): Int = chars.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val char = chars[position]
        holder.bind(char, position)
    }

    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: CharData, position: Int) {
            itemView.tv_char_name.text = item.name
            itemView.tv_char_subtitle.text = item.id

            var titles = ""
            item.titles.forEach {
                titles += it + '\n'
            }
            if (titles == "") titles = "None"

            itemView.tv_char_titles_list.text = titles
        }
    }
}