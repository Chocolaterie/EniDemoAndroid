package com.example.enidemo.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Player (@PrimaryKey val playerId : Int, val pseudo : String) {
}