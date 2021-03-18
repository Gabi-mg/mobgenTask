package com.mobgen.task.domain.repositories

import com.mobgen.task.data.network.service.Service

class CharRepository(private val services: Service) {
    suspend fun getListChar() = services.listChars()
}