package com.panaceasoft.pskotlinmaterial.repository.restaurant

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.panaceasoft.pskotlinmaterial.`object`.RestaurantFood

import java.util.ArrayList

object RestaurantFoodRepository {
    val restaurantFoodList: ArrayList<RestaurantFood>
        get() = Gson().fromJson<ArrayList<RestaurantFood>>(restaurantFoods, object : TypeToken<ArrayList<RestaurantFood>>() {

        }.type)

    internal var restaurantFoods = "[\n" +
            "  {\n" +
            "    \"name\":\"Starters\",\n" +
            "    \"image\":\"starters\",\n" +
            "    \"price\":\"15\",\n" +
            "    \"currency\":\"USD\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\":\"Salads\",\n" +
            "    \"image\":\"slads\",\n" +
            "    \"price\":\"20\",\n" +
            "    \"currency\":\"EUR\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\":\"Classic Pizza\",\n" +
            "    \"image\":\"classic_pizza\",\n" +
            "    \"price\":\"25\",\n" +
            "    \"currency\":\"USD\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\":\"Romana Pizza\",\n" +
            "    \"image\":\"romana_pizza\",\n" +
            "    \"price\":\"10\",\n" +
            "    \"currency\":\"EUR\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\":\"Pizza Bundles\",\n" +
            "    \"image\":\"pizza_bundles\",\n" +
            "    \"price\":\"19\",\n" +
            "    \"currency\":\"EUR\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\":\"Pastas\",\n" +
            "    \"image\":\"pastas\",\n" +
            "    \"price\":\"30\",\n" +
            "    \"currency\":\"USD\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\":\"White Wine\",\n" +
            "    \"image\":\"white_wine\",\n" +
            "    \"price\":\"15\",\n" +
            "    \"currency\":\"USD\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\":\"Red Wine\",\n" +
            "    \"image\":\"red_wine\",\n" +
            "    \"price\":\"40\",\n" +
            "    \"currency\":\"EUR\"\n" +
            "  }\n" +
            "]"
}
