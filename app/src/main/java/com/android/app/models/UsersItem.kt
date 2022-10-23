package com.android.app.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UsersItem(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val email: String,
    val is_moderator: Boolean,
    val phone_number: String,
    val public_name: String,
    val user_id: Int
)