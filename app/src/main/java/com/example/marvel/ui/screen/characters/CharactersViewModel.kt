package com.example.marvel.ui.screen.characters

import androidx.lifecycle.MutableLiveData

import com.example.marvel.data.network.model.Results
import com.example.marvel.data.repository.Repository
import com.example.marvel.ui.base.AbsViewModel
import com.example.marvel.utils.viewModel.ioToUi
import javax.inject.Inject

class CharactersViewModel @Inject constructor(
    private val repository: Repository
) : AbsViewModel() {

    val liveData = MutableLiveData<List<Results>>()

    fun fetchCharacter() {
        ioToUi(
            io = {
                val result = repository.getCharacter()
                result
            },
            ui = {
                liveData.value = it
            }
        )
    }

    fun searchCharacter(name: String) {
        ioToUi(
            io = {
                val result = repository.searchCharacter(name)
                result
            },
            ui = {
                liveData.value = it
            }
        )
    }

}
