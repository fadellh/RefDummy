package com.example.feature_home.data.api.response

import com.example.feature_home.data.domain.RefferalList
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonQualifier

//Gson
data class RefferalListResponse(
    @SerializedName(value = "id")
    val id:Int,
    @SerializedName(value = "patient_name")
    val patientName: String,
    @SerializedName(value = "status")
    val status: Int
)

/*data class RefferalListResponse(
    @Json(name = "id")
    val id:Int,
    @Json(name = "patient_name")
    val patientName: String,
    @Json(name = "status")
    val status: Int
)*/

fun RefferalListResponse.toDomain() =
    RefferalList(
        patient_name = patientName,
        status = status
    )

//Moshi
internal fun RefferalListResponse.toEntity() =
    com.example.feature_home.data.persistance.entity.RefferalList(
        id = id,
        patientName = patientName,
        status = status
    )
