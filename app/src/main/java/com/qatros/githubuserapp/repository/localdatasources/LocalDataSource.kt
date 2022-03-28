package com.qatros.githubuserapp.repository.localdatasources

import com.qatros.githubuserapp.model.database.UserEntity
import com.qatros.githubuserapp.model.response.UserResponse
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

/**
 * @author rivki
 * Created 24/03/22 at 15.35
 */
interface LocalDataSource {
    fun insertData(users: List<UserEntity>): Completable
    fun getLocalData(): Observable<List<UserEntity>>
}