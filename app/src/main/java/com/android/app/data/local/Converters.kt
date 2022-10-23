package com.android.app.data.local

import androidx.room.TypeConverter
import com.android.app.models.UsersItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    @TypeConverter
    fun dayslistToGson(list: ArrayList<UsersItem>): String = Gson().toJson(list)

    @TypeConverter
    fun gsonToDaysList(string: String): ArrayList<UsersItem> {
        val listType = object : TypeToken<ArrayList<UsersItem>>() {}.type
        return Gson().fromJson(string, listType)
    }
}