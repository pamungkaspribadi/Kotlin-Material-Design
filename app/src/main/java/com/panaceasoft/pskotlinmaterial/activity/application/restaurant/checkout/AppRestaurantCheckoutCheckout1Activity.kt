package com.panaceasoft.pskotlinmaterial.activity.application.restaurant.checkout

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.panaceasoft.pskotlinmaterial.R
import kotlinx.android.synthetic.main.app_restaurant_checkout_checkout_1_activity.*

class AppRestaurantCheckoutCheckout1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_restaurant_checkout_checkout_1_activity)

        initData()

        initUI()

        initDataBinding()

        initActions()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initData() {

    }

    private fun initUI() {
        initToolbar()
    }

    private fun initDataBinding() {

    }

    private fun initActions() {

        cashCardView.setOnClickListener { Toast.makeText(this, "Clicked Cash On Delivery.", Toast.LENGTH_SHORT).show() }
        paypalCardView.setOnClickListener { Toast.makeText(this, "Clicked Paypal.", Toast.LENGTH_SHORT).show() }
        cardCardView.setOnClickListener { Toast.makeText(this, "Clicked Card.", Toast.LENGTH_SHORT).show() }
        enterCouponCardView.setOnClickListener { Toast.makeText(this, "Clicked Enter Coupon.", Toast.LENGTH_SHORT).show() }
        payButton.setOnClickListener { Toast.makeText(this, "Clicked Pay.", Toast.LENGTH_SHORT).show() }

        copyImageView.setOnClickListener{
            val cManager = applicationContext.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val cData = ClipData.newPlainText("text", transactionNoTextView.text)
            cManager.primaryClip = cData
            Toast.makeText(applicationContext, "Copied to clipboard.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_black_24)


        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.setTitle("Checkout 1")

        try {
            toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.md_white_1000))
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
}
