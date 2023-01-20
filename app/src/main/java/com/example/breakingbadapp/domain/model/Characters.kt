package com.example.breakingbadapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.breakingbadapp.navigation.util.Constants.CHARACTERS_DATABASE_TABLE
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = CHARACTERS_DATABASE_TABLE)
data class Characters(
    @PrimaryKey(autoGenerate = false)
    val id:Int,
    val name:String,
    val image:String,
    val designation:String,
    val tags : List<String>,
    val about:String,
    val rating:Double,
    val power:Int,
    val famousDialogue:String,
    val intelligence:Int,
    val abilities:List<String>,
    val kills:Int
)
