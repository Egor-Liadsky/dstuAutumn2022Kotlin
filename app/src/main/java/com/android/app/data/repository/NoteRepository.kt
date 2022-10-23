package com.android.app.data.repository

import com.android.app.data.api.ApiService
import com.android.app.models.Note
import javax.inject.Inject

class NoteRepository @Inject constructor(private val api: ApiService) {
    suspend fun getNote(): ArrayList<Note> = api.getNote()
}