package com.mobgen.task.data.network.model

import com.google.gson.annotations.SerializedName

data class CategoryData (
    @SerializedName("category_name") val categoryName : String,
    @SerializedName("type") val type : Int
)