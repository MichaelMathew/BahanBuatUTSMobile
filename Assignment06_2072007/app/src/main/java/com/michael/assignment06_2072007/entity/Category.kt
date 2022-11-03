/**
 * Author - Michael Mathew Setiadi / 2072007
 */

package com.michael.assignment06_2072007.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Category(private val name: String): Parcelable {
    override fun toString(): String {
        return "$name"
    }
}
