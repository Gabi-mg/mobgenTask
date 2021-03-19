package com.mobgen.task.app.ui

import androidx.lifecycle.*
import com.mobgen.task.app.ui.base.BaseViewModel
import com.mobgen.task.data.network.model.CategoryData
import com.mobgen.task.domain.usecases.CategoryUseCase
import kotlinx.coroutines.*

class SplashViewModel(private val categoryUseCase: CategoryUseCase) : BaseViewModel() {

    private val categories = MutableLiveData<List<CategoryData>>()

    fun runCategories () {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                try {
                    val result = categoryUseCase.run()
                    delay(4000)
                    categories.postValue(result)
                } catch (throwable: Throwable) {
                    setError(throwable)
                }
            }
        }
    }

    fun getCategories(): LiveData<List<CategoryData>>{
        return categories
    }

}