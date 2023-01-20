package com.example.breakingbadapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.breakingbadapp.data.local.dao.CharacterDao
import com.example.breakingbadapp.data.local.dao.CharaterRemoteKeyDao
import com.example.breakingbadapp.domain.model.Characters
import com.example.breakingbadapp.domain.model.CharactersRemoteKeys


@Database(entities = [Characters::class,CharactersRemoteKeys::class], version = 1)
@TypeConverters(DataBaseConvertor::class)
abstract class BreakingBadDatabase :RoomDatabase(){
    abstract fun charactersDao(): CharacterDao

    abstract fun charactersRemoteKeyDao():CharaterRemoteKeyDao
}