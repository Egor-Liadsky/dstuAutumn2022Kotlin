package com.android.app.data.repository

import com.android.app.data.api.ApiService
import com.android.app.models.AllTaskModelItem
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

    suspend fun getAllTask(): ArrayList<AllTaskModelItem> = api.selectAllTasks()
}