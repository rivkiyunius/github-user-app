package com.qatros.githubuserapp.repository.remotedatasources

import com.qatros.githubuserapp.model.ApiService
import com.qatros.githubuserapp.model.response.UserResponse
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

/**
 * @author rivki
 * Created 24/03/22 at 13.12
 */
class RemoteDataSourcesImpl @Inject constructor(private val service: ApiService): RemoteDataSources {
    override fun getAllUsers(): Observable<List<UserResponse>> = service.getUsers(10)

}