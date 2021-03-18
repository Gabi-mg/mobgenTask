package com.mobgen.task.domain.repositories

import com.mobgen.task.data.network.service.Service

class CategoryRepository(private val services: Service) {
    suspend fun getListCategory() = services.listCategories()
}