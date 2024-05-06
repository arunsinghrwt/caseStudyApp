package com.target.targetcasestudy.network

import com.target.targetcasestudy.network.data.Deal
import com.target.targetcasestudy.network.data.DealItem
import com.target.targetcasestudy.network.data.DealResponse

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface ApiService {
    @GET("mobile_case_study_deals/v1/deals/{id}")
    @Headers("accept: application/json")
    suspend fun retrieveDeal(@Path("id") dealId: Int): Response<DealItem>

    @GET("mobile_case_study_deals/v1/deals")
    suspend fun retrieveDeals(): Response<DealResponse>
}
