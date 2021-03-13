package id.technicaltest.core.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converter {

    @TypeConverter
    fun fromStringList(string: List<String>): String {
        val type = object : TypeToken<List<String>>() {}.type
        return Gson().toJson(string, type)
    }

    @TypeConverter
    fun toStringList(string: String): List<String> {
        val type = object : TypeToken<List<String>>() {}.type
        return Gson().fromJson(string, type)
    }
}