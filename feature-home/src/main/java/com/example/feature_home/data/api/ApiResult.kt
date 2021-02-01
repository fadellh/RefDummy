package com.example.feature_home.data.api

import retrofit2.Call
import retrofit2.Callback

internal sealed class ApiResult<out T> {
    data class OnSuccess<out T>(val response: T) : ApiResult<T>()
    data class OnFailed<T>(val exception: Call<T>) : ApiResult<Nothing>()
}