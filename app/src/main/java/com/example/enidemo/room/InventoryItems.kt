package com.example.enidemo.room

import androidx.room.Embedded
import androidx.room.Relation

data class InventoryItems (
    @Embedded val inventory: Inventory,
    @Relation(
        parentColumn = "inventoryId",
        entityColumn = "inventoryOwnerId"
    )
    var items : List<Item>
        )
{
}