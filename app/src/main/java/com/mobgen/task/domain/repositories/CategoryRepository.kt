package com.mobgen.task.domain.repositories

import com.mobgen.task.data.network.service.CategoryService

class CategoryRepository(private val categoryServices: CategoryService) {
    suspend fun getListCategory() = categoryServices.listCategories()
}