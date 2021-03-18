package com.mobgen.task.domain.usecases

import com.mobgen.task.data.network.model.HouseData
import com.mobgen.task.domain.repositories.HouseRepository


class HouseUseCase(private val houseRepository: HouseRepository) {

    suspend fun run(): List<HouseData> {
        return houseRepository.getListHouse()
    }
}