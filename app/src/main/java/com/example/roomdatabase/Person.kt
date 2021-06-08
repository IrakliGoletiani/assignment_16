package com.example.roomdatabase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Person (
    val firstName: String,
    val lastName: String,
    val age: Int,
    val address: String,
    val height: Int,
    val profile: String,
    @PrimaryKey val id: Int
)