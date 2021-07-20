package com.example.marvel.ui.screen.comics

import androidx.lifecycle.MutableLiveData
import com.example.marvel.data.network.model.Results
import com.example.marvel.data.repository.Repository
import com.example.marvel.ui.base.AbsViewModel
import com.example.marvel.utils.viewModel.ioToUi
import javax.inject.Inject

class ComicsViewModel @Inject constructor(
    private val repository: Repository
) : AbsViewModel() {

    val livedata = MutableLiveData<List<Results>>()

    fun fetchComics() {
        ioToUi(
            io = {
                 val result = repository.getComics()
                result
            },
            ui = {
                livedata.value = it
            }
        )
    }



}