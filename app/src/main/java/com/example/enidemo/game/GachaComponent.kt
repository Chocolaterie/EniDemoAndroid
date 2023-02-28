package com.example.enidemo.game

import kotlin.random.Random

enum class GachaRewardType {
    Character,
    Equipment
}
class GachaItem {
    var type = GachaRewardType.Character
    var id = 0
}

class GachaLoteryResult {

    var rewardItems : ArrayList<GachaItem> = arrayListOf()
}

class GachaComponent: ActorComponent() {

    fun lotery(tryCount : Int) : GachaLoteryResult {
        var gachaLoteryResult = GachaLoteryResult()

        // Pour chaque nombre d'essaie
        for (i in 0..tryCount){
            // > 0.5 = Lotery success
            if (Random.nextFloat() > 0.5f) {
                gachaLoteryResult.rewardItems.add(GachaItem())
            }
        }

        return gachaLoteryResult
    }
}