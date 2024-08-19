package com.pajri.submissionakhir

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Laptop (
    val name: String,
    val desc: String,
    val photo: String,
    val price: String
        ): Parcelable