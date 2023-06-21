package com.bignerdranch.android.mvp.lesson2_moxy_cicerone.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GithubUser(
    val login: String
) : Parcelable
