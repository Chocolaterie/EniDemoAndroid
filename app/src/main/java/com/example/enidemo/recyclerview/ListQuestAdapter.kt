package com.example.enidemo.recyclerview

import android.view.LayoutInflater
import android.view.View.OnClickListener
import android.view.ViewGroup
import com.example.enidemo.room.Quest
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.enidemo.databinding.QuestRowStyleBinding

class ListQuestAdapter(val clickListener: QuestListener) : ListAdapter<Quest, ListQuestAdapter.ViewHolder>(QuestDiffCallback()){

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, clickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder(val binding: QuestRowStyleBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(item: Quest, clickListener: QuestListener) {
            binding.quest = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ListQuestAdapter.ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = QuestRowStyleBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
    }

}