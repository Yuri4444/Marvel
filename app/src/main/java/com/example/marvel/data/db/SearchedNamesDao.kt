package com.example.marvel.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SearchedNamesDao {

    @Query("Select * from searchedNames_table")
    suspend fun getAllSearchedNames(): List<SearchedNames>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSearchedName(searchedNames: SearchedNames)

}