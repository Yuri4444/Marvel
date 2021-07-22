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
    val allLiveData = MutableLiveData<ArrayList<Results>>(ArrayList())
    var isFetching = false
    private var offset = 0

    private var isLastPage = false

    init {
        fetchCharacter()
    }

    fun fetchCharacter() {

        if (!isLastPage) {
            if (!isFetching) {
                isFetching = true
                ioToUi(
                    io = {

                        val answer = netRepository.getCharacter(limit = LIMIT, offset = offset)

                        if (answer.size < LIMIT) {
                            isLastPage = true
                        }
                        answer

                    },
                    ui = {
                        offset += LIMIT
                        liveData.value = it
                        liveData.value = emptyList()
                        allLiveData.value?.addAll(it)
                        isFetching = false
                    }
                )
            }
        }


    }

    fun searchCharacter(name: String) {
        ioToUi(
            io = {
                netRepository.searchCharacter(name)
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

    companion object {
        const val LIMIT = 100
    }

}
