package com.mobgen.task.domain.repositories

import com.mobgen.task.data.network.service.Service

class HouseRepository(private val services: Service) {
    suspend fun getListHouse() = services.listHouses()
}