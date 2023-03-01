package com.example.enidemo.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Quest(@PrimaryKey(autoGenerate = true) val questId:Int, val name: String) {
}