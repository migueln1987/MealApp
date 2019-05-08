package com.example.mealapp.network

import com.example.mealapp.data.models.CategoryList
import com.example.mealapp.data.models.Meal
import com.example.mealapp.utils.Constants
import retrofit2.Call
import retrofit2.http.GET

interface MealService {

    @GET(Constants.CATEGORIES_PATH)
    fun getCategories() : Call<CategoryList>

    @GET(Constants.RANDOM_RECIPE_PATH)
    fun getRandomMean() : Call<Meal>
}