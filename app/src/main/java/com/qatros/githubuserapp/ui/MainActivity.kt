package com.qatros.githubuserapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.qatros.githubuserapp.base.DiffCallback
import com.qatros.githubuserapp.databinding.ActivityMainBinding
import com.qatros.githubuserapp.model.response.UserResponse
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), HomeAdapter.RvListener {
    private val bind by lazy { ActivityMainBinding.inflate(layoutInflater) }
    @Inject lateinit var diffCallback: DiffCallback
    private lateinit var layoutManagers: LinearLayoutManager
    private val userAdapter by lazy { HomeAdapter(diffCallback, this) }
    private val vm by viewModels<HomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bind.root)
        init()
        observeData()
    }

    private fun init() {
        vm.getUsers()
        layoutManagers = LinearLayoutManager(this)
        bind.rvUser.run {
            layoutManager = layoutManagers
            adapter = userAdapter
        }
    }

    private fun observeData(){
        vm.run {
            user.observe(this@MainActivity){
                userAdapter.setUsers(it)
            }
        }
    }

    override fun onClickListener(data: UserResponse) {
//        "${data.login}, ${data.url}, ${data.}"
    }
}