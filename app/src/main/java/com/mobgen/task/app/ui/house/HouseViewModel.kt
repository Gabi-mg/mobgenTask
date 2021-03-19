package com.mobgen.task.app.ui.house

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.mobgen.task.app.ui.base.BaseViewModel
import com.mobgen.task.data.network.model.HouseData
import com.mobgen.task.domain.usecases.HouseUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HouseViewModel(private val houseUseCase: HouseUseCase) : BaseViewModel() {
    private val houses = MutableLiveData<List<HouseData>>()

    fun runHouses () {
        setIsLoading(true)
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                try {
                    val result = houseUseCase.run()
                    houses.postValue(result)
                } catch (throwable: Throwable) {
                    setError(throwable)
                }
            }
        }
    }

    fun getHouses() : LiveData<List<HouseData>>{
        return houses
    }
}