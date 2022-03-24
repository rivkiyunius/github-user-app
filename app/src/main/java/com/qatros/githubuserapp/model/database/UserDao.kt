package com.qatros.githubuserapp.model.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * @author rivki
 * Created 24/03/22 at 13.36
 */
@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertData(user: List<UserEntity>)
}