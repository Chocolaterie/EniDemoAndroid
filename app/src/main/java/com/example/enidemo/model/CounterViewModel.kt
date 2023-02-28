package com.example.enidemo.model
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {

    var counter = MutableLiveData<Int>()

    init {
        counter.value = 0
    }

    fun incrementer(){
        counter.value = (counter.value)?.plus(1)
    }
}