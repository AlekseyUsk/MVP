package com.bignerdranch.android.mvp.lesson2_moxy_cicerone.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.mvp.databinding.ItemUserBinding
import com.bignerdranch.android.mvp.lesson2_moxy_cicerone.IUserListPresenter
import com.bignerdranch.android.mvp.lesson2_moxy_cicerone.view.list.UserItemView

class UsersRVAdapter(private val presenter: IUserListPresenter) :
    RecyclerView.Adapter<UsersRVAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root), UserItemView {

        override var pos = -1

        override fun setLogin(text: String) = with(binding) {
            tvLogin.text = text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        ).apply {
            itemView.setOnClickListener {
                presenter.itemClickListener?.invoke(this)
            }
        }

    override fun getItemCount() = presenter.getCount()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        presenter.bindView(holder.apply { pos = position })

}