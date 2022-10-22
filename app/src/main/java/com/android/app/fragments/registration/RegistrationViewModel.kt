package com.android.app.fragments.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.app.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(private val repository: UserRepository) :
    ViewModel() {

    var id = 0

    fun register(
        email: String,
        name: String,
        phone: String
        ) = viewModelScope.launch(Dispatchers.IO) {
        repository.register(email, phone, name)
        id = repository.getUserId()
    }

    init {
        id = repository.getUserId()
    }

}