package com.example.hikeu

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity
data class UnOfficialTrails (
    @NonNull @PrimaryKey(autoGenerate = true)  val id: Int,
//    @NonNull @ForeignKey(Entity = [Users::class]) val userId: Int,
    @NonNull var name: String,
    @NonNull var country: String,
    @NonNull var state: String,
    @NonNull var googleMapsLink: String,
    @NonNull var difficulty: String,
    @NonNull var duration: Int,
    @NonNull var warnings:String,
    @NonNull var clothing:String,
    @NonNull var indispensables: String,
    @NonNull var images: String,

)
{
    constructor(
        name:String,
        country: String,
        state: String,
        googleMapsLink: String,
        difficulty: String,
        duration: Int,
        warnings: String,
        clothing: String,
        indispensables: String,

        ): this(
        0,
        name,
        country,
        state,
        googleMapsLink,
        difficulty,
        duration,
        warnings,
        clothing,
        indispensables,
        "No images")
}