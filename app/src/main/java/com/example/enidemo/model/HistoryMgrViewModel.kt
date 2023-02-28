package com.example.enidemo.model

import androidx.lifecycle.LiveData

class HistoryMgr {
    var historyList = arrayListOf<History>()

    var currentIndex = 0;

    init {
        historyList.add(History("www.sitechelou.com/commentetreunbondev", "23/02/2023"))
        historyList.add(History("www.alala.com/qsdqsd", "23/02/2021"))
    }

    fun nextHistory() {
        currentIndex = 1
    }

    fun getCurrentHistory() : History {
        return historyList.get(currentIndex)
    }

}