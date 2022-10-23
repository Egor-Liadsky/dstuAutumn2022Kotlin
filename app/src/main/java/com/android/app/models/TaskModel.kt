package com.android.app.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TaskModel(
    @PrimaryKey (autoGenerate = true) val id: Int,
    val title: String,
    val description: String,
    val isHidden: Boolean,
    val startDate: String,
    val endDate: String
)