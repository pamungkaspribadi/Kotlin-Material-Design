package com.panaceasoft.pskotlinmaterial.adapter.application.restaurant.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.RestaurantFood
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.app_restaurant_home_2_item.view.*

import java.util.ArrayList

class AppRestaurantHome2Adapter(private val itemArrayList: ArrayList<RestaurantFood>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var itemClickListener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onItemClick(view: View, obj: RestaurantFood, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.app_restaurant_home_2_item, parent, false)

        return PlaceViewHolder(itemView)
    }

    override fun onBindViewHolder(reholder: RecyclerView.ViewHolder, position: Int) {

        if (reholder is PlaceViewHolder) {
            val item = itemArrayList[position]

            reholder.categoryNameTextView.text =item.name

            val context = reholder.placeHolderCardView.context

            val id = Utils.getDrawableInt(context, item.imageName)
            Utils.setImageToImageView(context, reholder.itemImageView, id)


            reholder.placeHolderCardView.setOnClickListener { view ->
                if (itemClickListener != null) {
                    itemClickListener!!.onItemClick(view, itemArrayList[position], position)
                }
            }

        }

    }

    override fun getItemCount(): Int {
        return itemArrayList.size
    }

    inner class PlaceViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var placeHolderCardView: CardView = view.placeHolderCardView
        var itemImageView: ImageView = view.itemImageView
        var categoryNameTextView: TextView = view.categoryNameTextView

    }

}

