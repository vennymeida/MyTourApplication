package com.dicoding.mytourapplication

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Tour(
    val name: String,
    val description: String,
    val photo: Int
) : Parcelable
