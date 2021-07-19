package com.example.marvel.ui.screen.characters

import androidx.lifecycle.MutableLiveData
import com.example.autoapp.utils.extensions.viewModel.ioToUi
import com.example.marvel.data.network.model.HeroesList
import com.example.marvel.data.repository.CharactersRepository
import com.example.marvel.ui.base.AbsViewModel
import javax.inject.Inject

class CharactersViewModel @Inject constructor(
    private val charactersRepository: CharactersRepository
) : AbsViewModel() {

    val liveData = MutableLiveData<List<HeroesList>>()

    fun fetch() {
        ioToUi(
            io = {
                val result = charactersRepository.getHeroes()
                result
            },
            ui = {
                liveData.value = it
            }
        )
    }

}
