/**
 * Author - Michael Mathew Setiadi / 2072007
 */

package com.michael.kotlinq1.entity
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Data(
    @SerializedName ("_id") val id:String,
    @SerializedName ("age") val age:String,
    @SerializedName ("address") val address:String,
    @SerializedName ("phone") val phone:String,
    @SerializedName ("name") val name:String,
    @SerializedName ("company") val company:String,
    @SerializedName ("email") val email:String,
    @SerializedName ("tags") val tags:ArrayList<String>,
    @SerializedName ("friends") val friends:ArrayList<Friend>,

) : Parcelable
