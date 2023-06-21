package com.bignerdranch.android.mvp.lesson2_moxy_cicerone

import com.bignerdranch.android.mvp.lesson2_moxy_cicerone.view.list.IItemView
import com.bignerdranch.android.mvp.lesson2_moxy_cicerone.view.list.UserItemView

interface IListPresenter <V : IItemView> {
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int
}
interface IUserListPresenter : IListPresenter<UserItemView>