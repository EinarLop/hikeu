package com.example.hikeu

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class OfficialTrails (
    @NonNull @PrimaryKey(autoGenerate = true)  val id: Int,
    @NonNull var name: String,
    @NonNull var country: String,
    @NonNull var state: String,
    @NonNull var googleMapsLink: String,
    @NonNull var difficulty: Int,
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
        difficulty: Int,
        duration: Int,
        warnings: String,
        clothing: String,
        indispensables: String,
        images: String,
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
        images)
}