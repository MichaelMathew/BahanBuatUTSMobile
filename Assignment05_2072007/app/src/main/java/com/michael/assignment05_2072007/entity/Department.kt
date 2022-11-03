package com.michael.assignment05_2072007.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Department(private val code: String,private val name: String) : Parcelable {
    override fun toString(): String {
        return "$code - $name"
    }
}