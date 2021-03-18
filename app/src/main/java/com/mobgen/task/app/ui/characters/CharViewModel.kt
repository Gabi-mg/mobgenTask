package com.mobgen.task.app.ui.characters

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.mobgen.task.app.ui.base.BaseViewModel
import com.mobgen.task.data.network.model.CharData
import com.mobgen.task.domain.usecases.CharUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CharViewModel(private val charUseCase: CharUseCase) : BaseViewModel() {
    val chars = MutableLiveData<List<CharData>>()

    fun runBooks () {
        isLoading.value = true
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                try {
                    val result = charUseCase.run()
                    chars.postValue(result)
                } catch (throwable: Throwable) {
                    setError(throwable)
                }
            }
        }
    }
}