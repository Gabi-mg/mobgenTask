package com.mobgen.task.data.network.model

import com.google.gson.annotations.SerializedName

data class CategoryData (
    @SerializedName("category_name") val categoryName : String,
    @SerializedName("type") val type : Int
)


data class BookData (
    @SerializedName("name") val name : String,
    @SerializedName("isbn") val isbn : String,
    @SerializedName("authors") val authors : List<String>,
    @SerializedName("numberOfPages") val numberOfPages : Int,
    @SerializedName("publisher") val publisher : String,
    @SerializedName("country") val country : String,
    @SerializedName("mediaType") val mediaType : String,
    @SerializedName("released") val released : String
)

data class CharData (
    @SerializedName("id") val id : String,
    @SerializedName("name") val name : String,
    @SerializedName("gender") val gender : String,
    @SerializedName("culture") val culture : String,
    @SerializedName("born") val born : String,
    @SerializedName("died") val died : String,
    @SerializedName("titles") val titles : List<String>,
    @SerializedName("aliases") val aliases : List<String>,
    @SerializedName("father") val father : String,
    @SerializedName("mother") val mother : String,
    @SerializedName("spouse") val spouse : String,
    @SerializedName("allegiances") val allegiances : List<String>,
    @SerializedName("playedBy") val playedBy : List<String>
)

data class HouseData (
    @SerializedName("id") val id : String,
    @SerializedName("name") val name : String,
    @SerializedName("region") val region : String,
    @SerializedName("title") val culture : String
)