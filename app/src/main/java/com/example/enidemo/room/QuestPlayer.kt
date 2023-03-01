package com.example.enidemo.room

import androidx.room.Entity

@Entity(primaryKeys = ["questId", "playerId"])
class QuestPlayer (val questId: Int, val playerId: Int){
}