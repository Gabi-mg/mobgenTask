package com.mobgen.task.domain.usecases

import com.mobgen.task.data.network.model.CharData
import com.mobgen.task.domain.repositories.CharRepository


class CharUseCase(private val charRepository: CharRepository) {

    suspend fun run(): List<CharData> {
        return charRepository.getListChar()
    }
}