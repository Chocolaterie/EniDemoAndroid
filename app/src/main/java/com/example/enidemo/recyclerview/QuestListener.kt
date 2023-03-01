package com.example.enidemo.recyclerview

import com.example.enidemo.room.Quest

class QuestListener (val clickListener : (quest : Quest) -> Unit){

    fun onClick(quest: Quest) = clickListener(quest)
}