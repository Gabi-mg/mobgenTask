package com.mobgen.task.domain.repositories

import com.mobgen.task.data.network.service.Service

class BookRepository(private val services: Service) {
    suspend fun getListBook() = services.listBooks()
}