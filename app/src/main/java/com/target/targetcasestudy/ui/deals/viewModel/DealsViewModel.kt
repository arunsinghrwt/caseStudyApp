package com.target.targetcasestudy.ui.deals.viewModel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.target.targetcasestudy.network.data.DealItem

import com.target.targetcasestudy.network.data.DealResponse
import com.target.targetcasestudy.ui.deals.repository.DealsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DealsViewModel @Inject constructor(private val repository: DealsRepository) : ViewModel(){

    private val _dealsListResponseData = MutableLiveData<DealResponse>()
    val dealsListResponseData: LiveData<DealResponse> get() = _dealsListResponseData


    fun getDealsListData() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = repository.getDealsList()
                _dealsListResponseData.postValue(response.body())
            } catch (e: Exception) {
                Log.e("ExceptionLiveData1", "-->>>$e")

            }
        }
    }


    private val _responseData = MutableLiveData<DealItem>()
    val responseData: LiveData<DealItem> get() = _responseData

    fun getDealDetailsDetails(dealId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = repository.getDetails(dealId)
                _responseData.postValue(response.body())
            } catch (e: Exception) {
                Log.e("ExceptionLiveData2", "-->>>${e.cause}")

            }
        }
    }



}



