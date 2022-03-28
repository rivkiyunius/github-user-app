package com.qatros.githubuserapp.model.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.qatros.githubuserapp.model.response.UserResponse
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

/**
 * @author rivki
 * Created 24/03/22 at 13.36
 */
@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertData(user: List<UserEntity>): Completable

    @Query("SELECT * FROM users")
    fun getLocalUser(): Observable<List<UserEntity>>
}