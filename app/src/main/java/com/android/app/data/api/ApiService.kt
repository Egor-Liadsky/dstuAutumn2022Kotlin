package com.android.app.data.api

import com.android.app.models.AllTaskModel
import com.android.app.models.AllTaskModelItem
import com.android.app.models.UsersItem
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

    @POST("create_task")
    suspend fun addTask(
        @Query("from_id") id: Int,
        @Query("to_id") toId: Int,
        @Query("title") title: String,
        @Query("text") description: String,
        @Query("is_secret") isSecret: Boolean,
        @Query("time_start") startDate: String,
        @Query("time_end") endDate: String
    )


    @GET("select_all_users")
    suspend fun getAllUsers(): ArrayList<UsersItem>

    @GET("select_all_task")
    suspend fun selectAllTasks(): ArrayList<AllTaskModelItem>
}