package com.example.mealapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mealapp.data.models.Category
import com.example.mealapp.data.models.Meal

@Database(entities = arrayOf(Category::class, Meal::class), version = 1, exportSchema = false)
abstract class MealDatabase : RoomDatabase(){

    companion object {
        private const val DATABASE_NAME = "meal_database"
        @Volatile
        private var INSTANCE: MealDatabase? = null
        private val LOCK = Any()
        operator fun invoke(context: Context) = INSTANCE?: synchronized(LOCK) {
            INSTANCE?: buildDatabase(context).also{ mealDatabase -> INSTANCE = mealDatabase }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context,
            MealDatabase::class.java,
            DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }
    abstract fun mealDao(): MealDao

}