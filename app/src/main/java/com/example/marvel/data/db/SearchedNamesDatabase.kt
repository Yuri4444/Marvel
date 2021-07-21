package com.example.marvel.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [SearchedNames::class], version = 1, exportSchema = false)
abstract class SearchedNamesDatabase : RoomDatabase() {

    abstract fun searchedNamesDao(): SearchedNamesDao

    companion object {
        const val DATABASE_NAME = "SearchedNamesDatabase"
    }

}