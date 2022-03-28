package com.qatros.githubuserapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.qatros.githubuserapp.base.DiffCallback
import com.qatros.githubuserapp.databinding.ItemViewBinding
import com.qatros.githubuserapp.model.response.UserResponse
import com.qatros.githubuserapp.utils.showImages

/**
 * @author rivki
 * Created 25/03/22 at 16.56
 */
class HomeAdapter(
    private var diffCallback: DiffCallback = DiffCallback(),
    private var listener: RvListener
) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    private var userList = mutableListOf<UserResponse>()

    fun setUsers(data: List<UserResponse>) {
        calculateDiff(data)
    }

    private fun calculateDiff(newData: List<UserResponse>){
        diffCallback.setList(userList, newData)
        val result = DiffUtil.calculateDiff(diffCallback)
        userList.run {
            clear()
            addAll(newData)
            notifyDataSetChanged()
        }
        result.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(userList[position], position == userList.size-1, listener)
    }

    override fun getItemCount(): Int = userList.size

    inner class ViewHolder(private var bind: ItemViewBinding) : RecyclerView.ViewHolder(bind.root) {
        fun bindItem(user: UserResponse, isLast: Boolean, listener: RvListener){
            bind.run {
                imgRepo.showImages(user.avatarUrl.toString())
                tvItemName.text = user.login
                tvItemId.text = user.id.toString()
                tvItemRepo.text = user.reposUrl
                if (isLast) itemViewUser.setPadding(0, 16, 0, 16)
            }
            itemView.setOnClickListener {
                listener.onClickListener(user)
            }
        }

    }

    interface RvListener {
        fun onClickListener(data: UserResponse)
    }
}