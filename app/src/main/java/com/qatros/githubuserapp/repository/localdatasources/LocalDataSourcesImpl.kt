package com.qatros.githubuserapp.repository.localdatasources

import com.qatros.githubuserapp.model.database.UserDao
import com.qatros.githubuserapp.model.database.UserEntity
import com.qatros.githubuserapp.model.response.UserResponse
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

/**
 * @author rivki
 * Created 24/03/22 at 15.37
 */
class LocalDataSourcesImpl @Inject constructor(private val userDao: UserDao) : LocalDataSource {
    override fun insertData(users: List<UserEntity>): Completable = userDao.insertData(users)

    override fun getLocalData(): Observable<List<UserEntity>> = userDao.getLocalUser()
}