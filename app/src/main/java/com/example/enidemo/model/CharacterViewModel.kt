package com.example.enidemo.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CharacterViewModel : ViewModel() {

    var pseudo = MutableLiveData<String>()
    var level = MutableLiveData<Int>()

    fun levelUp(){
        level.value = (level.value)?.plus(1)
    }

    fun editPseudo(newPseudo : String){
        (pseudo)?.value = newPseudo
    }
}