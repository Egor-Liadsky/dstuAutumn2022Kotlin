package com.android.app.data.local.database

import androidx.room.RoomDatabase
import com.android.app.data.local.dao.TasksDao

abstract class TaskRoomDatabase(): RoomDatabase() {

    abstract fun tasksDao(): TasksDao
}