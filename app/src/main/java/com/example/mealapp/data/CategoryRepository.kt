package com.example.mealapp.data

import android.app.Application
import android.os.AsyncTask
import com.example.mealapp.data.models.Category

class CategoryRepository(application: Application) {
    private var mealDao: MealDao
    private var allCategories: List<Category>

    init {
        val database = MealDatabase.invoke(application)
        mealDao = database.mealDao()
        allCategories = mealDao.getAllCategories()
    }

    fun insert(category: Category) {

    }

    fun getAllCategories(): List<Category> = allCategories

    companion object {
        private class InsertCategoryAsyncTask(val mealDao: MealDao) : AsyncTask<Category, Void, String>() {
            override fun doInBackground(vararg params: Category?): String {
                mealDao.insertAllCategories(params)
                return "Hello"
            }

        }
    }
}