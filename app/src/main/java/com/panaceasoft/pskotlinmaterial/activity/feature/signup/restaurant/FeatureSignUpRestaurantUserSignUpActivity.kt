package com.panaceasoft.pskotlinmaterial.activity.feature.signup.restaurant

import android.os.Bundle
import android.text.InputType
import android.view.MotionEvent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.app_restaurant_user_user_sign_up_activity.*

class FeatureSignUpRestaurantUserSignUpActivity : AppCompatActivity() {

    //region override functions
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_sing_up_restaurant_user_sign_up_activity)

        initDataBindings()

        initActions()

    }
    //endregion

    //region Init Functions

    private fun initDataBindings() {
        val id = R.drawable.bg_smoke_grey
        Utils.setImageToImageView(applicationContext, bgImageView, id)
    }

    private fun initActions() {
        forgotButton.setOnClickListener {Toast.makeText(applicationContext, "Clicked Forgot Password", Toast.LENGTH_SHORT).show() }

        createTextView.setOnClickListener {Toast.makeText(applicationContext, "Clicked Login", Toast.LENGTH_SHORT).show() }

        registerButton.setOnClickListener {Toast.makeText(applicationContext, "Clicked Sign Up", Toast.LENGTH_SHORT).show() }

        showOrHidePasswordIcon.setOnTouchListener { v, event ->

            when (event.action) {

                MotionEvent.ACTION_UP -> editText7.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD

                MotionEvent.ACTION_DOWN -> editText7.inputType = InputType.TYPE_CLASS_TEXT
            }
            true
        }

    }
    //endregion
}
