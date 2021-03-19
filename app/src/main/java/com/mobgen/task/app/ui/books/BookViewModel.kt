package com.mobgen.task.app.ui.books

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.mobgen.task.app.ui.base.BaseViewModel
import com.mobgen.task.data.network.model.BookData
import com.mobgen.task.domain.usecases.BookUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BookViewModel(private val bookUseCase: BookUseCase) : BaseViewModel() {
    private val books = MutableLiveData<List<BookData>>()

    fun runBooks () {
        setIsLoading(true)
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                try {
                    val result = bookUseCase.run()
                    books.postValue(result)
                } catch (throwable: Throwable) {
                    setError(throwable)
                }
            }
        }
    }

    fun getBooks() : LiveData<List<BookData>>{
        return books
    }
}