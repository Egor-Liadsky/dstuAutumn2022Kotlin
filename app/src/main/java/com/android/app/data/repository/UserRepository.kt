package com.android.app.data.repository

import com.android.app.data.api.ApiService
import javax.inject.Inject

class UserRepository @Inject constructor(private val api: ApiService) {

    suspend fun register(
        email: String,
        phone: String,
        name: String
    ) = runCatching { api.register(email, phone, name) }
}