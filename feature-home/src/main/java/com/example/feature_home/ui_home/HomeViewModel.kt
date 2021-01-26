package com.example.feature_home.ui_home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.feature_home.data.api.request.RefferalListRequest
import com.example.feature_home.data.domain.RefferalList
import com.example.feature_home.data.repository.RefferalRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import retrofit2.Response


internal class HomeViewModel @ViewModelInject constructor(
    val refferalRepository: RefferalRepository
): ViewModel(){


    private val _readAllDataAsFlow = MutableLiveData<List<RefferalList>>()
    val readAllDataAsFlow : LiveData<List<RefferalList>> = _readAllDataAsFlow

    var refResponse : MutableLiveData<Response<List<RefferalList>>> = MutableLiveData()

    init {
        viewModelScope.launch {
            refferalRepository.getAllReferralAsFlow()
                .collect { _readAllDataAsFlow.value = it}
        }
    }

    fun getDataReferral () {
        viewModelScope.launch {

            val response : Response<List<RefferalList>> = refferalRepository.getAllListReferral()
            refResponse.value = response
        }
    }

    fun addDataPatient (ref: com.example.feature_home.data.persistance.entity.RefferalList) {
        viewModelScope.launch {
            refferalRepository.insertReferral(ref)
        }
    }

    fun createPatient (request: RefferalListRequest) {
        viewModelScope.launch {
            refferalRepository.createPatient(request)
        }
    }


}