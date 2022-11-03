package com.michael.assignment05_2072007.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.Date

@Parcelize
data class Student(private val id: String, private val firstName: String, private val lastName: String,
                   private val address: String, private val phone: String, private val gender: String,
                   private val birthDate: Date,private val department: Department): Parcelable {

    override fun toString(): String {
        return "id : $id " + "\n" +
                "Firstname : $firstName" + "\n" +
                "Lastname : $lastName" + "\n" +
                "Address  : $address" + "\n" +
                "Phone    : $phone" + "\n" +
                "Gender   : $gender" + "\n" +
                "Birthdate: $birthDate" + "\n" +
                "Department: $department"
    }

}