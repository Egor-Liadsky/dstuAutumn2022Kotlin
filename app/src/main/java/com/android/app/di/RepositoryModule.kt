package com.android.app.di

import com.android.app.data.api.ApiService
import com.android.app.data.repository.TaskRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideTaskRepository(apiService: ApiService): TaskRepository = TaskRepository(apiService)
}