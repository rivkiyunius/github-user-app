package com.qatros.githubuserapp.di

import android.content.Context
import androidx.room.Room
import com.qatros.githubuserapp.model.database.UserDao
import com.qatros.githubuserapp.repository.localdatasources.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @author rivki
 * Created 24/03/22 at 14.17
 */
@Module
@InstallIn(SingletonComponent::class)
object RoomModules {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "github-db").build()

    @Provides
    @Singleton
    fun provideUserDao(appDatabase: AppDatabase): UserDao = appDatabase.userDao()
}