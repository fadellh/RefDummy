package com.example.feature_home.data.api.request

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

data class RefferalListRequest
(
        @SerializedName(value = "patientName")
        val patientName : String
)