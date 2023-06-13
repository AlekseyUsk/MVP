package com.bignerdranch.android.mvp.model

class CountersModel {

    private val counters = mutableListOf(0, 0, 0)

    fun next(index: Int): Int {
        counters[index]++
        return getCurrent(index)
    }

    private fun getCurrent(index: Int): Int {
        return counters[index]
    }

    fun set(index: Int, value: Int) {
        counters[index] = value
    }
}