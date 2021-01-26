package com.example.feature_home.data.api

import com.example.feature_home.data.api.service.RefferalService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiClient {

    private val retrofitRefferalGson by lazy {
        Retrofit.Builder()
            .baseUrl(Constant.REFFERAL_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    private val retrofitRefferalMoshi by lazy {
        Retrofit.Builder()
                .baseUrl(Constant.REFFERAL_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
    }

    val getReferralListApiGson : RefferalService by lazy {
        retrofitRefferalGson.create(RefferalService::class.java)
    }

    val referralListMoshi : RefferalService by lazy {
        retrofitRefferalMoshi.create(RefferalService::class.java)
    }


}
