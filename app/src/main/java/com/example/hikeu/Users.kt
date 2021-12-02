package com.example.hikeu

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity
data class Users(
    @NonNull @PrimaryKey(autoGenerate = true)  val id: Int,
    @NonNull var username: String,
    @NonNull var password: String,
    @NonNull var email: String,
    @NonNull var age: Int,
    @NonNull var numberOfHikes: Int,
    @NonNull var favoriteHike: String,
    @NonNull var dreamHike: String,
)

{
    constructor(
        username: String,
        password: String,
        email: String,
    ) :this
        (0,
        username,
        password,
        email,
        0,
        0,
        "No answer",
        "No answer")
}