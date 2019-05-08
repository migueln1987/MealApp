package com.example.mealapp

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.example.mealapp.data.CategoryRepository
import com.example.mealapp.data.models.Category
import com.example.mealapp.data.models.CategoryList
import com.example.mealapp.network.MealService
import com.example.mealapp.network.RetrofitClientInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryViewModel(application: Application) : AndroidViewModel(application) {

    private var repository: CategoryRepository = CategoryRepository(application)
    private var allCategories = repository.getAllCategories()

    fun getAllCategories(): List<Category> = allCategories

    fun insertCategories() {
        var mealService = RetrofitClientInstance.getRetrofit()?.create(MealService::class.java)
        val call = mealService?.getCategories()

        call?.enqueue(object: Callback<CategoryList>{
            override fun onFailure(call: Call<CategoryList>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.localizedMessage}")
            }
            override fun onResponse(call: Call<CategoryList>, response: Response<CategoryList>) {
                when(response.isSuccessful) {
                    true -> {
                        Log.d(TAG, "onResponse: ${response.body()}")
                        // TODO: Save response to database
                    }
                    false -> Log.d(TAG, "onResponse: ${response.errorBody().toString()}")
                }
            }
        })
    }

    companion object {
        const val TAG = "CategoryViewModel"
    }
}