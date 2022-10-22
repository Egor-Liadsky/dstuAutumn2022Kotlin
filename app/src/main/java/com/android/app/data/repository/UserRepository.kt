package com.android.app.data.repository

import com.android.app.data.api.ApiService
import com.android.app.data.preferences.EncryptedPreferencesStore
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val api: ApiService,
    private val preferences: EncryptedPreferencesStore
) {

    suspend fun register(
        email: String,
        name: String,
        phone: String
    ) = runCatching { setUserId(api.register(email, phone, name)) }

    suspend fun login(
        email: String,
        phone: String
    ) = runCatching { setUserId(api.login(email, phone)) }

    fun getUserId(): Int = preferences.getSavedId()

    fun setUserId(id: Int) = preferences.saveUserId(id)
}