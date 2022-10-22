package com.android.app.fragments.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.app.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: UserRepository) : ViewModel() {

    var id = 0

    fun login(
        email: String,
        phone: String
    ) = viewModelScope.launch(Dispatchers.IO) {
        repository.login(email, phone)
        id = repository.getUserId()
    }

    init {
        id = repository.getUserId()
    }

    fun getUserid() {
        id = repository.getUserId()
    }
}