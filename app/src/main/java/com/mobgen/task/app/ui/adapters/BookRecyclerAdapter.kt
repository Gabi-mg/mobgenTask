package com.mobgen.task.app.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobgen.task.R
import com.mobgen.task.app.utils.Utils
import com.mobgen.task.data.network.model.BookData
import kotlinx.android.synthetic.main.item_book.view.*



class BookRecyclerAdapter(
    private val books: List<BookData>
): RecyclerView.Adapter<BookRecyclerAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_book, parent, false)
        )
    }

    override fun getItemCount(): Int = books.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val book = books[position]
        holder.bind(book, position)
    }

    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: BookData, position: Int) {
            itemView.tv_book_title.text = item.name
            itemView.tv_book_released_date.text = Utils.getPatternFormatFromDateString(item.released)
        }
    }
}