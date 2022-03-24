package com.qatros.githubuserapp.model

import com.qatros.githubuserapp.model.response.UserResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author rivki
 * Created 24/03/22 at 13.02
 */
interface ApiService {
    @GET("users")
    fun getUsers(@Query("per_page") page: Int): Observable<List<UserResponse>>
}