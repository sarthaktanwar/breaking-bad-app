package com.example.breakingbadapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.breakingbadapp.navigation.util.Constants.CHARACTERS_REMOTE_KEYS_DATABASE


@Entity(tableName = CHARACTERS_REMOTE_KEYS_DATABASE)
data class CharactersRemoteKeys(
    @PrimaryKey(autoGenerate = false)
    val id:Int,
    val prevPage:Int?,
    val nextPage:Int?

)
