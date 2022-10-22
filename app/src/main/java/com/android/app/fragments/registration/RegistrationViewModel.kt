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

    fun register(
        email: String,
        phone: String,
        name: String
    ) = viewModelScope.launch(Dispatchers.IO) {
        repository.register(email, phone, name)
    }
}