package com.example.enidemo.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.enidemo.room.Quest

class ListQuestViewModel (application: Application) : AndroidViewModel(application) {

    var quests = MutableLiveData<List<Quest>>()

    fun mock(){
        val questMock = listOf(Quest(1, "Quete1"), Quest(2, "Quete 2"), Quest(3, "Quete 3"));
        quests.value = questMock
    }


}