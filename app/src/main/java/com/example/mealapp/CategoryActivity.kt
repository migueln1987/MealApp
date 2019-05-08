package com.example.mealapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.mealapp.data.models.CategoryList
import com.example.mealapp.network.MealService
import com.example.mealapp.network.RetrofitClientInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
        categoriesRequest()
    }

    private fun categoriesRequest() {
        var mealService: MealService = RetrofitClientInstance.getRetrofit()!!.create(MealService::class.java)
        val call = mealService.getCategories()
        call.enqueue(object : Callback<CategoryList> {
            override fun onFailure(call: Call<CategoryList>, t: Throwable) {
                Log.d(MainActivity.TAG, "onFailure: ${t.localizedMessage}")

            }
            override fun onResponse(call: Call<CategoryList>, response: Response<CategoryList>) {
                when (response.isSuccessful) {
                    true -> Log.d(MainActivity.TAG, "onResponse: ${response.body()}")
                    false -> Log.d(MainActivity.TAG, "onResponse: ${response.errorBody().toString()}")
                }
            }
        })
    }
}
