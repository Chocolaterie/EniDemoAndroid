package com.example.enidemo.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DAOPlayer {

    @Insert
    fun insert(player: Player)

    @Insert
    fun insert(inventory: Inventory)

    @Insert
    fun insert(item: Item)

    @Insert
    fun insert(quest: Quest)

    @Insert
    fun insert(questPlayer: QuestPlayer)

    @Query("SELECT * FROM Player WHERE playerId = :id")
    operator fun get(id: Int): Player

    @Query("SELECT * FROM Player WHERE playerId = :id")
    fun getPlayerInventory(id: Int): PlayerInventory

    @Query("SELECT * FROM Inventory WHERE inventoryId = :id")
    fun getInventoryItems(id: Int): InventoryItems

    @Query("SELECT * FROM Player WHERE playerId = :id")
    fun getPlayerQuests(id: Int): PlayerWithQuests

    @Query("SELECT * FROM Quest WHERE questId = :id")
    fun getQuestWithPlayers(id: Int): QuestWithPlayers

}