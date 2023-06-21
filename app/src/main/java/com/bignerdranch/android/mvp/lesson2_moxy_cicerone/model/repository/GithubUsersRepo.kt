package com.bignerdranch.android.mvp.lesson2_moxy_cicerone.model.repository

import com.bignerdranch.android.mvp.lesson2_moxy_cicerone.model.GithubUser

class GithubUsersRepo {

    private val repositories = listOf(
        GithubUser("login1"),
        GithubUser("login2"),
        GithubUser("login3"),
        GithubUser("login4"),
        GithubUser("login5")
    )

    fun getUsers(): List<GithubUser> {
        return repositories
    }
}

