package com.qatros.githubuserapp.repository

import com.qatros.githubuserapp.model.response.UserResponse
import io.reactivex.rxjava3.core.Observable

/**
 * @author rivki
 * Created 24/03/22 at 13.14
 */
interface DataRepository {
    fun getAllUsers(): Observable<List<UserResponse>>
}