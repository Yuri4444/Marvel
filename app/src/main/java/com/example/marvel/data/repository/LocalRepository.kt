package com.example.marvel.data.repository

import com.example.marvel.data.db.SearchedNames
import com.example.marvel.data.db.SearchedNamesDatabase
import javax.inject.Singleton

@Singleton
class LocalRepository (private val searchedNamesDatabase: SearchedNamesDatabase) {

    suspend fun getSearchedNames() = searchedNamesDatabase.searchedNamesDao().getAllSearchedNames()

    suspend fun insertSearchedName(searchedNames: SearchedNames):SearchedNames {
        searchedNamesDatabase.searchedNamesDao().insertSearchedName(searchedNames)
        return searchedNames
    }

}