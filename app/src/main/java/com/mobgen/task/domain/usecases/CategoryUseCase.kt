package com.mobgen.task.domain.usecases

import com.mobgen.task.data.network.model.CategoryData
import com.mobgen.task.domain.repositories.CategoryRepository

class CategoryUseCase(private val categoryRepository: CategoryRepository) {

    suspend fun run(): List<CategoryData> {
        return categoryRepository.getListCategory()
    }


}