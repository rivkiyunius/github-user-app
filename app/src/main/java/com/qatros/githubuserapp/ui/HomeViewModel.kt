package com.qatros.githubuserapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.qatros.githubuserapp.base.BaseViewModel
import com.qatros.githubuserapp.model.response.UserResponse
import com.qatros.githubuserapp.repository.DataRepository
import com.qatros.githubuserapp.utils.BaseSchedulerProvider
import com.qatros.githubuserapp.utils.SchedulerProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @author rivki
 * Created 25/03/22 at 16.15
 */
@HiltViewModel
class HomeViewModel @Inject constructor(
    private var repository: DataRepository
) : BaseViewModel() {
    private val _user = MutableLiveData<List<UserResponse>>()
    val user: LiveData<List<UserResponse>> get() = _user

    fun getUsers(){
        repository.getAllUsers().onResult {
            _user.postValue(it)
        }
    }

}