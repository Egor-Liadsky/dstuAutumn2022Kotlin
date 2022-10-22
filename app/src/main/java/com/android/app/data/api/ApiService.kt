package com.android.app.data.api

import retrofit2.http.*

interface ApiService {

    @POST("register")
    suspend fun register(
        @Query("email") email: String,
        @Query("name") name: String,
        @Query("phone") phone: String
    ): Int

    @GET("login")
    suspend fun login(
        @Query("email") email: String,
        @Query("phone") phone: String
    ): Int
}