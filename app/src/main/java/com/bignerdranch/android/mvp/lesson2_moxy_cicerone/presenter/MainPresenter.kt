package com.bignerdranch.android.mvp.lesson2_moxy_cicerone.presenter

import com.bignerdranch.android.mvp.lesson2_moxy_cicerone.IUserListPresenter
import com.bignerdranch.android.mvp.lesson2_moxy_cicerone.view.list.UserItemView
import com.bignerdranch.android.mvp.lesson2_moxy_cicerone.model.GithubUser
import com.bignerdranch.android.mvp.lesson2_moxy_cicerone.model.repository.GithubUsersRepo
import com.bignerdranch.android.mvp.lesson2_moxy_cicerone.view.MainView
import moxy.MvpPresenter

class MainPresenter(private val usersRepo: GithubUsersRepo) : MvpPresenter<MainView>() {

    class UsersListPresenter : IUserListPresenter {

        val users = mutableListOf<GithubUser>()

        override var itemClickListener: ((UserItemView) -> Unit)? = null //todo дз

        override fun getCount() = users.size

        override fun bindView(view: UserItemView) {
            val user = users[view.pos]
            view.setLogin(user.login)
        }
    }

    val usersListPresenter = UsersListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()
        usersListPresenter.itemClickListener = { itemView ->
//TODO: переход на экран пользователя
        }
    }

    private fun loadData() {
        val users = usersRepo.getUsers()
        usersListPresenter.users.addAll(users)
        viewState.updateList()
    }
}
