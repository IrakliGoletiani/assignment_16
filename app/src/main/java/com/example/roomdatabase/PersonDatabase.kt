package com.example.roomdatabase

import androidx.room.Room

object PersonDatabase {
    val db = Room.databaseBuilder(
        App.appContext!!,
        Database::class.java, "database-name"
    ).build()
}