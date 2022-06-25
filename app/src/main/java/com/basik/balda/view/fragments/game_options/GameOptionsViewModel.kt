package com.basik.balda.view.fragments.game_options

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.basik.balda.model.GamePlayer
import com.basik.balda.view.base.BaseViewModel
import javax.inject.Inject

class GameOptionsViewModel @Inject constructor() : BaseViewModel() {

    private val playersMutable = MutableLiveData<List<GamePlayer>>(emptyList())
    val players: LiveData<List<GamePlayer>> = playersMutable

    fun generateRandomWord() {

    }

    fun addPlayer(nickName: String) {

    }

    fun removePlayer(index: Int) {

    }

    fun reduceFieldSize() {

    }

    fun increaseFieldSize() {

    }

    fun startGame() {

    }
}