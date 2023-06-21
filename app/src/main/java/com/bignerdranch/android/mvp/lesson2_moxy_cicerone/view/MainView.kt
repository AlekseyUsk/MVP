package com.bignerdranch.android.mvp.lesson2_moxy_cicerone.view

import com.bignerdranch.android.mvp.lesson2_moxy_cicerone.model.repository.GithubUsersRepo
import com.bignerdranch.android.mvp.lesson2_moxy_cicerone.presenter.MainPresenter
import moxy.MvpView
import moxy.ktx.moxyPresenter
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface MainView : MvpView {
    fun init()
    fun updateList()
}
