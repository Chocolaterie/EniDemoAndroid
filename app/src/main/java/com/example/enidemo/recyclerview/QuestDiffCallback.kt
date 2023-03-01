package com.example.enidemo.recyclerview

import com.example.enidemo.room.Quest
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.DiffUtil.DiffResult

class QuestDiffCallback : DiffUtil.ItemCallback<Quest>() {

    override fun areItemsTheSame(oldItem: Quest, newItem: Quest): Boolean {
        return oldItem.questId == newItem.questId
    }

    override fun areContentsTheSame(oldItem: Quest, newItem: Quest): Boolean {
        return oldItem.equals(newItem)
    }
}