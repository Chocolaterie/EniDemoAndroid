package com.example.enidemo.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Item (@PrimaryKey(autoGenerate = true) val itemId : Int, val label: String, val inventoryOwnerId : Int) {
}