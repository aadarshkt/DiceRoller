package com.example.diceroller

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class MainViewModel : ViewModel() {

    private val _diceState = MutableLiveData(1)
    val diceState : LiveData<Int> = _diceState

    fun generateRandomNumber() {
        _diceState.value = Random.nextInt(6) + 1
    }
}