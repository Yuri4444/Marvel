package com.example.marvel.ui.screen.saved

import androidx.lifecycle.MutableLiveData
import com.example.marvel.data.db.SearchedNames
import com.example.marvel.data.repository.LocalRepository
import com.example.marvel.ui.base.AbsViewModel
import com.example.marvel.utils.viewModel.ioToUi
import javax.inject.Inject

class SavedViewModel @Inject constructor(
    private val localRepository: LocalRepository
) : AbsViewModel() {

    val savedNamesLiveData = MutableLiveData<List<SearchedNames>>()

    fun getAllSavedNames() {
        ioToUi(
            io = {
                localRepository.getSearchedNames()
            },
            ui = {
                savedNamesLiveData.value = it
            }
        )
    }

}