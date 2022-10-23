package com.android.app.models

data class AllTaskModelItem(
    val from_id: Int,
    val is_secret: Boolean,
    val progress_end: Int,
    val progress_start: Int,
    val task_id: Int,
    val text: String,
    val time_end: String,
    val time_start: String,
    val title: String,
    val to_id: Int
)