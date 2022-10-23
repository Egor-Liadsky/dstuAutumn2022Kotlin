package com.android.app.data.repository

import com.android.app.data.api.ApiService
import com.android.app.data.local.dao.TasksDao
import com.android.app.models.AllTaskModelItem
import com.android.app.models.TaskModel
import com.android.app.models.Users
import com.android.app.models.UsersItem
import javax.inject.Inject

class TaskRepository @Inject constructor(
    private val api: ApiService,
    private val taskDao: TasksDao
) {

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

    suspend fun insertTasks(list: TaskModel) = taskDao.insertTaskList(list)

    suspend fun getAllTasksDB():List<TaskModel> = taskDao.getAllTasksDB()

    suspend fun getAllTask(): List<TaskModel> = taskDao.getAllTasksDB()
}