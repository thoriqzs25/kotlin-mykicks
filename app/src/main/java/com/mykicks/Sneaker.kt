package com.mykicks

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Sneaker(
    val name: String,
    val color: String,
    val price: String,
    val date: String,
    val photo: Int,
    val description: String
) : Parcelable
