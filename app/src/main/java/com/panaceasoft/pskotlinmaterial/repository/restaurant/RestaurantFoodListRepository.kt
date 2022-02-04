package com.panaceasoft.pskotlinmaterial.repository.restaurant

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.panaceasoft.pskotlinmaterial.`object`.RestaurantFood

import java.util.ArrayList

object RestaurantFoodListRepository {
    val restaurantFoodList: ArrayList<RestaurantFood>
        get() = Gson().fromJson<ArrayList<RestaurantFood>>(restaurantFoods, object : TypeToken<ArrayList<RestaurantFood>>() {

        }.type)

    private var restaurantFoods = "[\n" +
            "  {\n" +
            "    \"name\":\"American Hot\",\n" +
            "    \"image\":\"american_hot\",\n" +
            "    \"price\":\"60\",\n" +
            "    \"description\":\"Pepperoni, mozzarella and passata with choice of hot green or jalapeño peppers.\",\n" +
            "    \"currency\":\"USD\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\":\"American Hottest\",\n" +
            "    \"image\":\"american_hottest\",\n" +
            "    \"price\":\"80\",\n" +
            "    \"description\":\"Pepperoni, hot green peppers, jalapeno, fresh red chilli, spicy Italian sausage, passata and buffalo mozzarella, finished with torn buffalo mozzarella, parsley and chilli oil.\",\n" +
            "    \"currency\":\"EUR\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\":\"Hawaiian\",\n" +
            "    \"image\":\"hawaiian\",\n" +
            "    \"price\":\"25\",\n" +
            "    \"description\":\"Ham with pineapple chutney, mozzarella, red onion, fresh basil, Parmesan and garlic oil on a creamy béchamel base. Finished with fresh parsley.\",\n" +
            "    \"currency\":\"USD\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\":\"Pomodoro Pesto\",\n" +
            "    \"image\":\"pomodoro_pesto\",\n" +
            "    \"price\":\"75\",\n" +
            "    \"description\":\"Mozzarella, passata, cherry tomatoes and garlic oil. Finished with basil and pesto genovese.\",\n" +
            "    \"currency\":\"EUR\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\":\"Giardiniera\",\n" +
            "    \"image\":\"giardiniera\",\n" +
            "    \"price\":\"50\",\n" +
            "    \"description\":\"Asparagus, butternut squash, mushrooms, roasted peppers, cherry tomatoes, olives, passata, mozzarella and garlic oil, finished with basil and pesto genovese.\",\n" +
            "    \"currency\":\"EUR\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\":\"Laksa\",\n" +
            "    \"image\":\"laksa\",\n" +
            "    \"price\":\"30\",\n" +
            "    \"description\":\"Prawns, mussels, squid clams, quail eggs, fried beancurd (tau pok) and homemade laksa sauce.\",\n" +
            "    \"currency\":\"USD\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\":\"Tandoori Chicken\",\n" +
            "    \"image\":\"tandoori_hicken\",\n" +
            "    \"price\":\"45\",\n" +
            "    \"description\":\"Chicken marinated in tandoori masala, with passata, red onions, red peppers and mozzarella. Finished with rosemary yoghurt and marinated cucumber.\",\n" +
            "    \"currency\":\"EUR\"\n" +
            "  }\n" +
            "]"
}

