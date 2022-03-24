package com.qatros.githubuserapp.repository.localdatasources

import androidx.room.Database
import androidx.room.RoomDatabase
import com.qatros.githubuserapp.model.database.UserDao
import com.qatros.githubuserapp.model.database.UserEntity

/**
 * @author rivki
 * Created 24/03/22 at 14.18
 */
@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
}