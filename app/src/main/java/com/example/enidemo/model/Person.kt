package com.example.enidemo.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Person (@PrimaryKey(autoGenerate = true) var id: Int, var firstname: String, var argent : Int){

}