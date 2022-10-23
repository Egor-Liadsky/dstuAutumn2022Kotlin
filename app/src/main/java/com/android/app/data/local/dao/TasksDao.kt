package com.android.app.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.app.models.TaskModel
import com.android.app.models.UsersItem

@Dao
interface TasksDao {

    @Query("SELECT*FROM TaskModel")
    suspend fun getAllTasksDB(): List<TaskModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTaskList(list: TaskModel)
}