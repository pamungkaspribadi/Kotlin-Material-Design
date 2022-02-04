package com.panaceasoft.pskotlinmaterial.activity.application.restaurant.checkout

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.panaceasoft.pskotlinmaterial.R
import kotlinx.android.synthetic.main.app_restaurant_checkout_checkout_2_activity.*

class AppRestaurantCheckoutCheckout2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_restaurant_checkout_checkout_2_activity)

        initActions()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }


    private fun initActions() {

        nextButton.setOnClickListener {  Toast.makeText(this, "Clicked Continue Shopping.", Toast.LENGTH_SHORT).show() }

        copyImageView!!.setOnClickListener {
            val cManager = applicationContext.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val cData = ClipData.newPlainText("text", transactionNoTextView.text)
            cManager.primaryClip = cData
            Toast.makeText(applicationContext, "Copied to clipboard.", Toast.LENGTH_SHORT).show()
        }

        viewDetailButton!!.setOnClickListener {Toast.makeText(this, "Clicked View Detail.", Toast.LENGTH_SHORT).show() }
    }

}
