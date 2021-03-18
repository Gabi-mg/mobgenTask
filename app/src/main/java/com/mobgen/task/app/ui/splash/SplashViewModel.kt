package com.mobgen.task.app.ui.splash

import androidx.lifecycle.*
import com.mobgen.task.data.network.model.CategoryData
import com.mobgen.task.domain.usecases.CategoryUseCase
import kotlinx.coroutines.*
import okhttp3.internal.wait
import retrofit2.HttpException
import java.io.IOException

class SplashViewModel(private val categoryUseCase: CategoryUseCase) : ViewModel() {

    val categories = MutableLiveData<List<CategoryData>>()
    private val errorMessage = MutableLiveData<String>()

    fun runCategories () {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                try {
                    val result = categoryUseCase.run()
                    delay(4000)
                    categories.postValue(result)
                } catch (throwable: Throwable) {
                    when (throwable) {
                        is IOException -> {
                            errorMessage.postValue("Network Error")
                        }
                        is HttpException -> {
                            val codeError = throwable.code()
                            val errorMessageResponse = throwable.message()
                            errorMessage.postValue("Error $errorMessageResponse : $codeError")
                        }
                        else -> {
                            errorMessage.postValue("Uknown error")
                        }
                    }
                }
            }
        }
    }

    fun getCategories() = categories.value
}