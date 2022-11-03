/**
 * Author - Michael Mathew Setiadi / 2072007
 */

package com.michael.assignment06_2072007.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Food(
    @SerializedName ("id") val id:String,
    @SerializedName ("nama_makanan") val name:String,
    @SerializedName ("harga") val price:Int,
    @SerializedName ("rating") val rating:Float,
    @SerializedName ("tanggal_pembuatan") val date: String,
    @SerializedName ("Category") val category: Category
) : Parcelable
