package com.android.app.fragments.notes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.app.data.repository.NoteRepository
import com.android.app.data.repository.UserRepository
import com.android.app.models.Note
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val repository: NoteRepository) :
    ViewModel() {

    var noteList = ArrayList<Note>()

    fun getNotes(){
        viewModelScope.launch(Dispatchers.IO) {
            noteList = repository.getNote()
            viewModelScope.cancel()
        }
    }

//    init {
//        id = repository.getUserId()
//    }

}