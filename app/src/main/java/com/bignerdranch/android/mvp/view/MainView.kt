package com.bignerdranch.android.mvp.view

interface MainView {

    fun setButtonText(index: Int, text: String)
    fun getButtonText(selectBtn: Int): Int

}