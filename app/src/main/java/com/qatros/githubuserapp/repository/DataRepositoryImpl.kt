package com.qatros.githubuserapp.repository

import com.qatros.githubuserapp.model.response.UserResponse
import com.qatros.githubuserapp.repository.localdatasources.LocalDataSource
import com.qatros.githubuserapp.repository.remotedatasources.RemoteDataSources
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

/**
 * @author rivki
 * Created 24/03/22 at 13.14
 */
class DataRepositoryImpl @Inject constructor(
    private val remote: RemoteDataSources,
    private val localDataSource: LocalDataSource
) : DataRepository {
    override fun getAllUsers(): Observable<List<UserResponse>> {
        return remote.getAllUsers()
    }
}