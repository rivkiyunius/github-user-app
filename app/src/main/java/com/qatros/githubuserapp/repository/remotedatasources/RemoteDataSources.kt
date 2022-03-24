package com.qatros.githubuserapp.repository.remotedatasources

import com.qatros.githubuserapp.model.response.UserResponse
import io.reactivex.rxjava3.core.Observable

/**
 * @author rivki
 * Created 24/03/22 at 13.11
 */
interface RemoteDataSources {
    fun getAllUsers(): Observable<List<UserResponse>>
}