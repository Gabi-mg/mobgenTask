package com.mobgen.task.app.ui.base


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.HttpException
import java.io.IOException

abstract class BaseViewModel() : ViewModel(){

    val errorMessage = MutableLiveData<String>()
    var isLoading = MutableLiveData<Boolean>()

    fun setError(throwable: Throwable){
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