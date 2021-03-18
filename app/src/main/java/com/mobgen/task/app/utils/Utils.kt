package com.mobgen.task.app.utils

import com.google.gson.Gson
import com.mobgen.task.data.network.model.CategoryData
import java.text.SimpleDateFormat

import java.util.*

class Utils {
    companion object{
        const val PATTERN_TRANSFORM_DATE_TO_SERVICE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss"
        const val PATTERN_GET_DATA = "dd/MM/yyyy"

        private val gson: Gson = Gson()

        fun toJson(list: List<Any>) : String{
            return gson.toJson(list)
        }

        fun fromJson(json: String) : Array<CategoryData>{
            return gson.fromJson(json, Array<CategoryData>::class.java)
        }

        fun getPatternFormatFromDateString(dateString: String): String {
            var finalString = ""
            try {
                val dateFormat = SimpleDateFormat(
                    PATTERN_TRANSFORM_DATE_TO_SERVICE_FORMAT,
                    Locale.getDefault()
                ).parse(dateString)
                val sdf = SimpleDateFormat(PATTERN_GET_DATA, Locale.getDefault())
                finalString = sdf.format(dateFormat)
            } catch (e: Exception) {
            }
            return finalString
        }
    }
}