package com.panaceasoft.pskotlinmaterial.`object`

import com.google.gson.annotations.SerializedName

class RestaurantFood(@field:SerializedName("name")
                     var name: String, @field:SerializedName("image")
                     var imageName: String, @field:SerializedName("currency")
                     var currency: String, @field:SerializedName("price")
                     var price: String, @field:SerializedName("description")
                     var description: String)
