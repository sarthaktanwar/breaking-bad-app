package com.example.breakingbadapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.breakingbadapp.domain.model.CharactersRemoteKeys

@Dao
interface CharaterRemoteKeyDao {

    @Query("SELECT * FROM characters_remote_keys_table WHERE id =:id")
    suspend fun getRemoteKeys(id:Int):CharactersRemoteKeys?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllRemoteKeys(charactersRemoteKey: List<CharactersRemoteKeys>)

    @Query("DELETE FROM characters_remote_keys_table")
    suspend fun deleteAllRemoteKeys()
}