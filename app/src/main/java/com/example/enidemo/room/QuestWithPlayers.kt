package com.example.enidemo.room

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

class PlayerWithQuests(
    @Embedded val player: Player,
    @Relation(
        parentColumn = "playerId",
        entityColumn = "questId",
        associateBy = Junction(QuestPlayer::class)
    ) val quests: List<Quest>
) {
}

class QuestWithPlayers(
    @Embedded val quest: Quest,
    @Relation(
        parentColumn = "questId",
        entityColumn = "playerId",
        associateBy = Junction(QuestPlayer::class)
    ) val players: List<Player>
) {

}