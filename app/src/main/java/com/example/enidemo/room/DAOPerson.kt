package com.example.enidemo.room

import androidx.room.*
import com.example.enidemo.model.Person

@Dao
interface DAOPerson {

    @Insert
    fun insert(person : Person)

    @Query("SELECT * FROM Person WHERE id = :id")
    operator fun get(id: Int) : Person

    @Update
    fun update(person : Person)

    @Delete
    fun delete(person : Person)

}