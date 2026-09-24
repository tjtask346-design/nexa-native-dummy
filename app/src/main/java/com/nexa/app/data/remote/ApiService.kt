package com.nexa.app.data.remote

import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @POST("api/auth/register-firebase")
    suspend fun registerFirebase(@Body body: Map<String, String>): Response<Map<String, Any>>

    @POST("api/auth/login-pin")
    suspend fun loginPin(@Body body: Map<String, String>): Response<Map<String, Any>>

    @GET("api/auth/me")
    suspend fun getMe(): Response<Map<String, Any>>

    @POST("api/kyc/submit")
    suspend fun submitKyc(@Body body: Map<String, String>): Response<Map<String, Any>>

    @GET("api/kyc/my")
    suspend fun getMyKyc(): Response<Map<String, Any>>

    @GET("api/transaction/balance")
    suspend fun getBalance(): Response<Map<String, Any>>

    @GET("api/transaction/history")
    suspend fun getHistory(): Response<Map<String, Any>>

    @POST("api/transaction/deposit")
    suspend fun deposit(@Body body: Map<String, Any>): Response<Map<String, Any>>

    @POST("api/transaction/withdraw")
    suspend fun withdraw(@Body body: Map<String, Any>): Response<Map<String, Any>>

    @POST("api/transaction/send")
    suspend fun send(@Body body: Map<String, Any>): Response<Map<String, Any>>

    @POST("api/tatum/create-deposit-address")
    suspend fun createDepositAddress(@Body body: Map<String, String>): Response<Map<String, Any>>
}
