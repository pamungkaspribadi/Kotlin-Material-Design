package com.panaceasoft.pskotlinmaterial.activity.feature.detail.restaurant

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.utils.Utils
import com.panaceasoft.pskotlinmaterial.utils.ViewAnimationUtils
import kotlinx.android.synthetic.main.app_restaurant_detail_detail_1_activity.*

class FeatureDetailRestaurantDetail1Activity : AppCompatActivity() {

    internal var price: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_detail_restaurant_detail_1_activity)

        initUI()

        initActions()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_basket_line, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        } else {
            Toast.makeText(applicationContext, item.title, Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }
    //endregion

    //region Init Functions


    private fun initUI() {
        constraintOne.visibility = View.GONE
        constraintTwo.visibility = View.GONE
        constraintThree.visibility = View.GONE

        initToolbar()

    }


    private fun initActions() {
        price = Integer.parseInt(priceTextView.text.toString())
        minusImageView.setOnClickListener {
            try {
                var value = Integer.parseInt(quantityTextView.text.toString())

                if (value > 1) {
                    value -= 1
                }
                quantityTextView.text = value.toString()
                val subTotal = value * price
                priceTextView.text = subTotal.toString()
            } catch (ignored: Exception) {
            }
        }


        plusImageView.setOnClickListener {

            try {
                var value = Integer.parseInt(quantityTextView.text.toString())

                value += 1

                quantityTextView.text = value.toString()
                val subTotal = value * price

                priceTextView.text = subTotal.toString()
            } catch (ignored: Exception) {
            }
        }
        addToCardButton.setOnClickListener {Toast.makeText(this@FeatureDetailRestaurantDetail1Activity, "Clicked Add To Card Button", Toast.LENGTH_SHORT).show() }
        payButton.setOnClickListener { Toast.makeText(this@FeatureDetailRestaurantDetail1Activity, "Clicked Pay Button", Toast.LENGTH_SHORT).show() }


        optionalArrowImageView.setOnClickListener { v: View ->
            val show = Utils.toggleUpDownWithAnimation(v)
            if (show) {
                ViewAnimationUtils.expand(constraintOne)
            } else {
                ViewAnimationUtils.collapse(constraintOne)
            }
        }

        staterArrowImageView.setOnClickListener { v: View ->
            val show = Utils.toggleUpDownWithAnimation(v)
            if (show) {
                ViewAnimationUtils.expand(constraintTwo)
            } else {
                ViewAnimationUtils.collapse(constraintTwo)
            }
        }

        drinkArrowImageView.setOnClickListener { v: View ->
            val show = Utils.toggleUpDownWithAnimation(v)
            if (show) {
                ViewAnimationUtils.expand(constraintThree)
            } else {
                ViewAnimationUtils.collapse(constraintThree)
            }
        }
    }

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_black_24)


        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this,R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Item Detail 1"

        try {
            toolbar.setTitleTextColor(ContextCompat.getColor(this,R.color.md_white_1000))
        } catch (e: Exception) {
            Log.e("TEAMPS", "Can't set color.")
        }

        try {
            setSupportActionBar(toolbar)
        } catch (e: Exception) {
            Log.e("TEAMPS", "Error in set support action bar.")
        }

        try {
            if (supportActionBar != null) {
                supportActionBar?.setDisplayHomeAsUpEnabled(true)
            }
        } catch (e: Exception) {
            Log.e("TEAMPS", "Error in set display home as up enabled.")
        }

    }
    //endregion
}
