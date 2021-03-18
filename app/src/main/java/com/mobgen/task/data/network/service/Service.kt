package com.mobgen.task.data.network.service

import com.mobgen.task.data.network.model.BookData
import com.mobgen.task.data.network.model.CategoryData
import com.mobgen.task.data.network.model.CharData
import com.mobgen.task.data.network.model.HouseData
import retrofit2.http.GET
import retrofit2.http.Headers

interface Service {
    @Headers("Accept: application/json")
    @GET("categories")
    suspend fun listCategories(): List<CategoryData>


    @Headers("Accept: application/json")
    @GET("list/1")
    suspend fun listBooks(): List<BookData>

    @Headers("Accept: application/json")
    @GET("list/2")
    suspend fun listHouses(): List<HouseData>

    @Headers("Accept: application/json")
    @GET("list/3")
    suspend fun listChars(): List<CharData>
}

