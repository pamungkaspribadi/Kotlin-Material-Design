package com.panaceasoft.pskotlinmaterial.activity.application.restaurant.basket

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.RestaurantFood
import com.panaceasoft.pskotlinmaterial.adapter.application.restaurant.basket.AppRestaurantBasketBasket1Adapter
import com.panaceasoft.pskotlinmaterial.repository.restaurant.RestaurantFoodRepository
import kotlinx.android.synthetic.main.app_restaurant_basket_basket_1_activity.*

import java.util.ArrayList

class AppRestaurantBasketBasket1Activity : AppCompatActivity() {

    lateinit var itemArrayList: ArrayList<RestaurantFood>
    lateinit var mAdapter: AppRestaurantBasketBasket1Adapter
    lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_restaurant_basket_basket_1_activity)

        initData()

        initUI()

        initDataBinding()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_clear_all, menu)
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
    private fun initData() {
        itemArrayList = RestaurantFoodRepository.restaurantFoodList
    }

    private fun initUI() {
        initToolbar()

        mAdapter = AppRestaurantBasketBasket1Adapter(itemArrayList)

        // get RecyclerView and bind
        recyclerView = findViewById(R.id.photoRecyclerView)
        val mLayoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = mLayoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()

        orderButton.setOnClickListener { Toast.makeText(this@AppRestaurantBasketBasket1Activity, "Clicked Order Button", Toast.LENGTH_SHORT).show() }
    }

    private fun initDataBinding() {
        recyclerView.adapter = mAdapter
    }


    private fun initToolbar() {

        val toolbar = findViewById<Toolbar>(R.id.toolbar)

        toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_black_24)


        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this,R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Basket 1"

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

