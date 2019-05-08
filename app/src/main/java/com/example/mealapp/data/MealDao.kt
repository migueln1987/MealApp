package com.example.mealapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mealapp.data.models.Category
import com.example.mealapp.data.models.Meal

@Dao
interface MealDao {

    @Query("SELECT * FROM category")
    fun getAllCategories() : List<Category>

    @Insert
    fun insertAllCategories(categoryList: Array<out Category?>)

    @Insert
    fun insertMeal(meal: Meal)

    @Insert
    fun insertCategory(category: Category)
}