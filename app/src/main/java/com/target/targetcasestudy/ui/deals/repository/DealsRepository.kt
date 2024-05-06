package com.target.targetcasestudy.ui.deals.repository

import androidx.lifecycle.MediatorLiveData
import com.target.targetcasestudy.network.ApiService
import com.target.targetcasestudy.network.data.DealItem
import com.target.targetcasestudy.network.data.DealResponse
import retrofit2.Response
import javax.inject.Inject


class DealsRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getDealsList(): Response<DealResponse> = apiService.retrieveDeals()
    suspend fun getDetails(dealId: Int): Response<DealItem> = apiService.retrieveDeal(dealId)

}