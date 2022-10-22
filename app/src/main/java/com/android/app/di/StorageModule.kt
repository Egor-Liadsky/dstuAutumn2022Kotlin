package com.android.app.di

import android.content.Context
import androidx.room.Room
import com.android.app.Constants
import com.android.app.data.local.database.TaskRoomDatabase
import com.android.app.data.preferences.EncryptedPreferencesStore
import com.android.app.data.preferences.PreferencesStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object StorageModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            TaskRoomDatabase::class.java,
            Constants.DB_NAME
        ).build()

    @Provides
    @Singleton
    fun provideTasksDao(db: TaskRoomDatabase) = db.tasksDao()

    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext context: Context) = PreferencesStore(context)

    @Provides
    @Singleton
    fun provideEncryptedSharedPreferences(@ApplicationContext context: Context) = EncryptedPreferencesStore(context)
}