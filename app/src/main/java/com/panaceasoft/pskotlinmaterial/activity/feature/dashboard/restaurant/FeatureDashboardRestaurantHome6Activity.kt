package com.panaceasoft.pskotlinmaterial.activity.feature.dashboard.restaurant

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.RestaurantFood
import com.panaceasoft.pskotlinmaterial.adapter.feature.dashboard.restaurant.FeatureDashboardRestaurantHome6Adapter
import com.panaceasoft.pskotlinmaterial.repository.restaurant.RestaurantFoodRepository
import kotlinx.android.synthetic.main.app_restaurant_home_6_activity.*
import java.util.*

class FeatureDashboardRestaurantHome6Activity : AppCompatActivity() {

    lateinit var itemArrayList: ArrayList<RestaurantFood>
    lateinit var mAdapter: FeatureDashboardRestaurantHome6Adapter
    lateinit var recyclerView: RecyclerView
    internal var numberOfColumns = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_dashboard_restaurant_home_6_activity)

        initData()

        initUI()

        initDataBinding()

        initActions()
        bottomNavigationView.selectedItemId = R.id.favouriteMenu
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            if (item.itemId == android.R.id.home) {
                finish()
            } else {
                when (item.itemId) {
                    R.id.searchMenu -> {
                    }
                    R.id.favouriteMenu -> {
                    }
                    R.id.saveMenu -> {
                    }
                    R.id.mailMenu -> {
                    }
                    R.id.profileMenu -> {
                    }
                }
            }

            true
        }
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
    private fun initData() {
        itemArrayList = RestaurantFoodRepository.restaurantFoodList
    }

    private fun initUI() {
        initToolbar()

        mAdapter = FeatureDashboardRestaurantHome6Adapter(itemArrayList)

        // get RecyclerView and bind
        recyclerView = findViewById(R.id.photoRecyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, numberOfColumns)
        recyclerView.itemAnimator = DefaultItemAnimator()

    }

    private fun initDataBinding() {
        recyclerView.adapter = mAdapter
    }

    private fun initActions() {
//        mAdapter!!.setOnItemClickListener({ view, obj, position -> Toast.makeText(this, "Selected : " + obj.name, Toast.LENGTH_LONG).show() })
    mAdapter.setOnItemClickListener(object : FeatureDashboardRestaurantHome6Adapter.OnItemClickListener{
        override fun onItemClick(view: View, obj: RestaurantFood, position: Int) {
            Toast.makeText(applicationContext, "Selected : " + obj.name, Toast.LENGTH_LONG).show()
        }

    })
    }

    private fun initToolbar() {
        toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_black_24)


        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this,R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Home 6"

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
