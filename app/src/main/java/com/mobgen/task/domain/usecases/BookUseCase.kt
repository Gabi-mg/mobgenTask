package com.mobgen.task.domain.usecases

import com.mobgen.task.data.network.model.BookData
import com.mobgen.task.domain.repositories.BookRepository

class BookUseCase(private val bookRepository: BookRepository) {

    suspend fun run(): List<BookData> {
        return bookRepository.getListBook()
    }
}