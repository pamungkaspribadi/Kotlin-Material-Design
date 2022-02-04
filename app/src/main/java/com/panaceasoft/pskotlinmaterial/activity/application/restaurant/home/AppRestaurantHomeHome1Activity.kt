package com.panaceasoft.pskotlinmaterial.activity.application.restaurant.home

import android.os.Bundle
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity

import com.panaceasoft.pskotlinmaterial.R
import kotlinx.android.synthetic.main.app_restaurant_home_1_activity.*

class AppRestaurantHomeHome1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_restaurant_home_1_activity)

        initAction()
    }

    private fun initAction() {
        letEatButton.setOnClickListener {Toast.makeText(this@AppRestaurantHomeHome1Activity, "Clicked Let's Eat Button", Toast.LENGTH_SHORT).show() }
    }

}
