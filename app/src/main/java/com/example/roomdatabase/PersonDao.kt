package com.example.roomdatabase

import androidx.room.*

@Dao
interface PersonDao {
    @Query("SELECT * FROM person")
    fun getAll(): List<Person>

    @Insert
    fun insertAll(vararg persons: Person)


}