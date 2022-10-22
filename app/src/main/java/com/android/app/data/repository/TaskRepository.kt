package com.android.app.data.repository

import com.android.app.data.api.ApiService
import javax.inject.Inject

class TaskRepository @Inject constructor(private val api: ApiService) {

    suspend fun addTask(
        id: Int,
        toId: Int,
        title: String,
        description: String,
        isSecret: Boolean,
        startDate: String,
        endDate: String
    ) = runCatching {
        api.addTask(
            id,
            toId,
            title,
            description,
            isSecret,
            startDate,
            endDate
        )
    }
}