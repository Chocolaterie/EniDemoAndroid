package com.example.enidemo.room

import androidx.room.Embedded
import androidx.room.Relation

data class PlayerInventory(
    @Embedded val player: Player?,
    @Relation(
        parentColumn = "playerId",
        entityColumn = "playerOwnerId"
    )
    val inventory: Inventory
) {

}