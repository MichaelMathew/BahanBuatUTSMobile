package com.michael.kotlinq1.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Friend(private val id: Int, private val name: String) : Parcelable {
    override fun toString(): String {
        return "$id - $name"
    }
}
