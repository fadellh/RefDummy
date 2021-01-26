package com.example.feature_home.data.api.service

import com.example.feature_home.data.api.request.RefferalListRequest
import com.example.feature_home.data.api.response.RefferalListResponse
import com.example.feature_home.data.domain.RefferalList
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RefferalService {

    @GET("/api/v1/allRef")
    suspend fun getAllRefferal() : Response<List<RefferalListResponse>>

    @POST("/api/v1/allRef")
    suspend fun createPatient(
            @Body request: RefferalListRequest
    ) : Response<RefferalListResponse>

}