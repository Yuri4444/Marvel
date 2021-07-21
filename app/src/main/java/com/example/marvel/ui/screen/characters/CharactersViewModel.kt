package com.example.marvel.ui.screen.characters

import androidx.lifecycle.MutableLiveData
import com.example.marvel.data.db.SearchedNames

import com.example.marvel.data.network.model.Results
import com.example.marvel.data.repository.LocalRepository
import com.example.marvel.data.repository.NetRepository
import com.example.marvel.ui.base.AbsViewModel
import com.example.marvel.utils.viewModel.ioToUi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

class CharactersViewModel @Inject constructor(
    private val netRepository: NetRepository,
    private val localRepository: LocalRepository
) : AbsViewModel() {

    val liveData = MutableLiveData<List<Results>>()

    fun fetchCharacter() {
        ioToUi(
            io = {
                val result = netRepository.getCharacter()
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
                val result = netRepository.searchCharacter(name)
                result
            },
            ui = {
                liveData.value = it
            }
        )
    }

    fun saveSearchedName(searchedNames: SearchedNames) {
        CoroutineScope(IO).launch {
            localRepository.insertSearchedName(searchedNames)
        }
    }

}
