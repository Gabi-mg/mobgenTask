package com.mobgen.task.app.utils

import com.google.gson.Gson
import com.mobgen.task.data.network.model.CategoryData

class Utils {
    companion object{
        private val gson: Gson = Gson()

        fun toJson(list: List<Any>) : String{
            return gson.toJson(list)
        }

        fun fromJson(json: String) : Array<CategoryData>{
            return gson.fromJson(json, Array<CategoryData>::class.java)
        }
    }
}