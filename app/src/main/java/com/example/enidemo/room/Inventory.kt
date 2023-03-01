package com.example.enidemo.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Inventory(@PrimaryKey val inventoryId : Int, val maxSlot : Int, val playerOwnerId : Int) {
}