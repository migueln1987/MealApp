package com.example.mealapp.utils

import androidx.room.TypeConverter
import java.util.*

object DateConverter {

    @JvmStatic
    @TypeConverter
    fun toDate(timestamp: Long) : Date? = Date(timestamp)

    @JvmStatic
    @TypeConverter
    fun toTimeStamp(date:Date): Long? = date.time
}