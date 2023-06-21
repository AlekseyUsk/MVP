package com.bignerdranch.android.mvp.lesson2_moxy_cicerone.presenter

import com.bignerdranch.android.mvp.lesson2_moxy_cicerone.IUserListPresenter
import com.bignerdranch.android.mvp.lesson2_moxy_cicerone.view.list.UserItemView
import com.bignerdranch.android.mvp.lesson2_moxy_cicerone.model.GithubUser
import com.bignerdranch.android.mvp.lesson2_moxy_cicerone.model.repository.GithubUsersRepo
import com.bignerdranch.android.mvp.lesson2_moxy_cicerone.view.UsersView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UsersPresenter(private val usersRepo: GithubUsersRepo, private val router: Router) :
    MvpPresenter<UsersView>() {
    class UsersListPresenter : IUserListPresenter {
        val users = mutableListOf<GithubUser>()
        override var itemClickListener: ((UserItemView) -> Unit)? = null
        override fun getCount() = users.size
        override fun bindView(view: UserItemView) {
            val user = users[view.pos]
            view.setLogin(user.login)
        }
    }

    private val usersListPresenter = UsersListPresenter()
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()
        usersListPresenter.itemClickListener = { itemView ->
//TODO: переход на экран пользователя c помощью router.navigateTo
        }
    }

    private fun loadData() {
        val users = usersRepo.getUsers()
        usersListPresenter.users.addAll(users)
        viewState.updateList()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}
