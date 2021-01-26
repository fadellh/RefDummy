package com.example.feature_home.data.repository

import android.util.Log
import com.example.feature_home.data.api.ApiClient
import com.example.feature_home.data.api.request.RefferalListRequest
import com.example.feature_home.data.api.response.toDomain
import com.example.feature_home.data.api.response.toEntity
import com.example.feature_home.data.api.service.RefferalService
import com.example.feature_home.data.persistance.dao.RefferalDao
import com.example.feature_home.data.persistance.entity.RefferalList
import com.example.feature_home.data.persistance.entity.toDomain
import kotlinx.coroutines.flow.map
import retrofit2.Response
import javax.inject.Inject


internal class RefferalRepository @Inject internal constructor(
    private val referralDao:RefferalDao
){
    suspend fun insertReferral(ref:RefferalList) = referralDao.insertRefferal(ref)

    suspend fun deleteReferral(ref:RefferalList) = referralDao.insertRefferal(ref)

   /* suspend fun getAllReferral() : Response<List<com.example.feature_home.data.domain.RefferalList>> {
        val result = referralDao.getAllRefferal()
        //return (result.body()?.map { it.toDomain()})
    }*/

    suspend fun replaceAllReferral(ref: List<RefferalList>) = referralDao.replaceAllReferral(ref)

    fun getAllReferralAsFlow() = referralDao.getAllRefferalAsFlow().map { it.map { res -> res.toDomain() } }

    suspend fun getAllListReferral() : Response<List<com.example.feature_home.data.domain.RefferalList>> {
        val result =  ApiClient.getReferralListApiGson.getAllRefferal()
        val codeSuccess = Response.success(result.code())
        val isCodeSuccess = Response.success(result.isSuccessful).code()

        if(isCodeSuccess < 300){
            Log.d("masuk pak eko","masuk pake eko")
          //  val response = Response.success(result.body()
            val hasil = result.body()!!.map { it.toEntity()}
            replaceAllReferral(hasil)
            return Response.success(result.body()?.map { it.toDomain()})
        }else{
            Log.d("errorrrr","Hai")
            return Response.success(result.body()?.map { it.toDomain()})
        }
    }

    suspend fun createPatient(request: RefferalListRequest) {
        val result = ApiClient.getReferralListApiGson.createPatient(request)
        val isCodeSuccess = Response.success(result).code()

        if (isCodeSuccess < 205){
            val hasil = result.body()!!.toEntity()
            insertReferral(hasil)
        }
    }
}