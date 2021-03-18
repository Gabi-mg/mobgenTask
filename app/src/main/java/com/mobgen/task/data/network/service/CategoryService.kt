package com.mobgen.task.data.network.service

import com.mobgen.task.data.network.model.CategoryData
import retrofit2.http.GET
import retrofit2.http.Headers

interface CategoryService {
    @Headers("Accept: application/json")
    @GET("categories")
    suspend fun listCategories(): List<CategoryData>
}