package com.android.app.data.api

import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @POST("register")
    suspend fun register(
        @Query("email") email: String,
        @Query("name") name: String,
        @Query("phone") phone: String
    )
}