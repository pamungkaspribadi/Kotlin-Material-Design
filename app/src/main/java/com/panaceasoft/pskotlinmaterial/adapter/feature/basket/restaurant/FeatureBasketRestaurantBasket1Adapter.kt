package com.panaceasoft.pskotlinmaterial.adapter.feature.basket.restaurant

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.RestaurantFood
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.app_restaurant_basket_basket_1_item.view.*

class FeatureBasketRestaurantBasket1Adapter(private val RestaurantFoodList: List<RestaurantFood>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    lateinit var currency: String
    private var total = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.feature_basket_restaurant_basket_1_item, parent, false)

        return PlaceViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        if (viewHolder is PlaceViewHolder) {

            val restaurantFood = RestaurantFoodList[position]
            currency = restaurantFood.currency
            viewHolder.itemNameTextView.text = restaurantFood.name

            val context = viewHolder.holderCardView.context

            val id = Utils.getDrawableInt(context, restaurantFood.imageName)
            Utils.setImageToImageView(context, viewHolder.itemImageView, id)

            viewHolder.currencyTextView.text = restaurantFood.currency

            try {
                val value = Integer.parseInt(viewHolder.qtyEditText.text.toString())
                val price = Integer.parseInt(restaurantFood.price)
                val subTotal = value * price
                val subTotalStr = subTotal.toString()

                total += subTotal

                viewHolder.subTotalTextView.text = subTotalStr
            } catch (ignored: Exception) {
            }

            viewHolder.minusImageView.setOnClickListener { v ->

                try {
                    var value = Integer.parseInt(viewHolder.qtyEditText.text.toString())

                    if (value > 1) {
                        value -= 1
                    }

                    viewHolder.qtyEditText.setText(value.toString())

                    val itemPriceStr = restaurantFood.price
                    if (itemPriceStr != "") {

                        val price = convertPriceStrToInt(itemPriceStr)
                        val originalSubTotal = convertPriceStrToInt(viewHolder.subTotalTextView.text.toString())
                        total -= originalSubTotal

                        val subTotal = value * price
                        val subTotalStr = subTotal.toString()
                        viewHolder.subTotalTextView.text = subTotalStr

                        total += subTotal

                    }

                } catch (ignored: Exception) {
                }
            }

            viewHolder.plusImageView.setOnClickListener { v ->

                try {
                    var value = Integer.parseInt(viewHolder.qtyEditText.text.toString())

                    value += 1

                    viewHolder.qtyEditText.setText(value.toString())

                    val itemPriceStr = restaurantFood.price
                    if (itemPriceStr != "") {

                        val price = convertPriceStrToInt(itemPriceStr)
                        val originalSubTotal = convertPriceStrToInt(viewHolder.subTotalTextView.text.toString())
                        total -= originalSubTotal

                        val subTotal = value * price
                        val subTotalStr = subTotal.toString()
                        viewHolder.subTotalTextView.text = subTotalStr

                        total += subTotal

                    }

                } catch (ignored: Exception) {
                }
            }

        }
    }

    private fun convertPriceStrToInt(priceStr: String): Int {
        var price = 0
        try {
            val lPriceStr = priceStr.replace(currency!!, "").replace(" ", "")
            price = Integer.parseInt(lPriceStr)
        } catch (ignored: Exception) {
        }

        return price
    }

    override fun getItemCount(): Int {
        return RestaurantFoodList.size
    }

    inner class PlaceViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
        var itemImageView: ImageView = view.itemImageView
        var itemNameTextView: TextView = view.itemNameTextView
        var holderCardView: CardView = view.holderCardView
        var subTotalTextView: TextView = view.subTotalTextView
        var minusImageView: ImageView = view.minusImageView
        var plusImageView: ImageView = view.plusImageView
        var qtyEditText: EditText = view.qtyEditText
        var currencyTextView: TextView = view.currencyTextView

    }
}
