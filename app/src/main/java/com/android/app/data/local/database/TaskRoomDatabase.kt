package com.android.app.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.android.app.data.local.Converters
import com.android.app.data.local.dao.TasksDao
import com.android.app.models.TaskModel
import com.android.app.models.Users
import com.android.app.models.UsersItem

@Database(entities = [TaskModel::class], version = 1)
@TypeConverters(Converters::class)
abstract class TaskRoomDatabase(): RoomDatabase() {

    abstract fun tasksDao(): TasksDao
}