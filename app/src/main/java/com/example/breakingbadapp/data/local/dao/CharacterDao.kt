package com.example.breakingbadapp.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.breakingbadapp.domain.model.Characters


@Dao
interface CharacterDao {

    @Query("SELECT * FROM characters_table ORDER BY id ASC")
    fun getAllCharacters():PagingSource<Int,Characters>

    @Query("SELECT * FROM characters_table WHERE id=:charactersId ")
    fun getSelectedCharacters(charactersId:Int):Characters

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     suspend fun addCharacters(charactersList:List<Characters>)

    @Query("DELETE FROM characters_table")
    suspend fun deleteAllCharacters()
}