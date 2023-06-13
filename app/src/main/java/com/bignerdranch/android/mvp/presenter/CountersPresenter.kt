package com.bignerdranch.android.mvp.presenter

import com.bignerdranch.android.mvp.*
import com.bignerdranch.android.mvp.model.CountersModel
import com.bignerdranch.android.mvp.view.MainView

class CountersPresenter(private val view: MainView) {
    private val model = CountersModel()

    fun counterClick(selectBtn: Int) {
        when (selectBtn) {
            view.getButtonText(BTN_COUNTER_ONE) -> {
                val nextValue = model.next(COUNTER_ONE)
                view.setButtonText(COUNTER_ONE, nextValue.toString())
            }
            view.getButtonText(BTN_COUNTER_TWO) -> {
                val nextValue = model.next(COUNTER_TWO)
                view.setButtonText(COUNTER_TWO, nextValue.toString())
            }
            view.getButtonText(BTN_COUNTER_THREE) -> {
                val nextValue = model.next(COUNTER_THREE)
                view.setButtonText(COUNTER_THREE, nextValue.toString())
            }
        }
    }
}
