package com.mobgen.task.app.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobgen.task.R
import com.mobgen.task.app.ui.house.Region
import com.mobgen.task.data.network.model.HouseData
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_house.view.*


class HouseRecyclerAdapter(
    private val context: Context,
    private val houses: List<HouseData>
): RecyclerView.Adapter<HouseRecyclerAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_house, parent, false)
        )
    }

    override fun getItemCount(): Int = houses.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val house = houses[position]
        holder.bind(house, position)
    }

    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: HouseData, position: Int) {
            itemView.tv_house_title.text = item.name
            itemView.tv_house_subtitle.text = item.region

            val imageUri = when(item.region){
                Region.NORTH -> Region.NORTH_LINK
                Region.VALE -> Region.VALE_LINK
                Region.RIVER -> Region.RIVER_LINK
                Region.IRON -> Region.IRON_LINK
                Region.WESTER -> Region.WESTER_LINK
                Region.REACH -> Region.REACH_LINK
                Region.DORNE -> Region.DORNE_LINK
                Region.STORM -> Region.STORM_LINK
                else -> null
            }

            Picasso.with(context)
                .load(imageUri)
                .into(itemView.im_house_region)


        }
    }
}