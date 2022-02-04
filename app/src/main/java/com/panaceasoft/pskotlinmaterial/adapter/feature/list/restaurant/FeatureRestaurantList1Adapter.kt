package com.panaceasoft.pskotlinmaterial.adapter.feature.list.restaurant

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
import kotlinx.android.synthetic.main.app_restaurant_list_1_item.view.*

class FeatureRestaurantList1Adapter(private val RestaurantFoodList: List<RestaurantFood>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.feature_restaurant_list_1_item, parent, false)

        return PlaceViewHolder(itemView)
    }

    override fun onBindViewHolder(reholder: RecyclerView.ViewHolder, position: Int) {

        if (reholder is PlaceViewHolder) {
            val item = RestaurantFoodList[position]

            reholder.itemNameTextView.text = item.name
            reholder.itemDescriptionTextView.text = item.description
            reholder.subTotalTextView.text = item.price
            reholder.currencyTextView.text =item.currency


            val context = reholder.holderCardView.context
            val id = Utils.getDrawableInt(context, item.imageName)
            Utils.setImageToImageView(context, reholder.itemImageView, id)

        }
    }

    override fun getItemCount(): Int {
        return RestaurantFoodList.size
    }

    inner class PlaceViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
        internal var itemImageView: ImageView = view.itemImageView
        internal var itemNameTextView: TextView = view.itemNameTextView7
        internal var itemDescriptionTextView: TextView = view.itemDescriptionTextView
        internal var subTotalTextView: TextView = view.subTotalTextView
        internal var currencyTextView: TextView = view.currencyTextView
        internal var holderCardView: CardView = view.holderCardView

    }
}

