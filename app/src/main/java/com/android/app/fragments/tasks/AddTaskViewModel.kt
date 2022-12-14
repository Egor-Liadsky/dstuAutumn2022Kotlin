package com.android.app.fragments.tasks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.app.data.repository.TaskRepository
import com.android.app.data.repository.UserRepository
import com.android.app.models.UsersItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddTaskViewModel @Inject constructor(
    private val taskRep: TaskRepository,
    private val userRepository: UserRepository
) : ViewModel() {

    var toId = 0
    var listUsers = ArrayList<UsersItem>()

    fun addTask(
        toId: Int?,
        title: String,
        description: String,
        isSecret: Boolean,
        startDate: String,
        endDate: String
    ) = viewModelScope.launch(Dispatchers.IO) {
        taskRep.addTask(
            userRepository.getUserId(),
            toId!!,
            title,
            description,
            isSecret,
            startDate,
            endDate
        )
        viewModelScope.cancel()
    }

    fun getAllUsers() = viewModelScope.launch(Dispatchers.IO) {
        listUsers = userRepository.allUsers()
    }
}