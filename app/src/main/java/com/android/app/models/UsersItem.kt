package com.android.app.models

data class UsersItem(
    val email: String,
    val is_moderator: Boolean,
    val phone_number: String,
    val public_name: String,
    val user_id: Int
)