package com.android.app.models

import androidx.room.Entity

@Entity
data class Users(
    val taskList: ArrayList<UsersItem>
)