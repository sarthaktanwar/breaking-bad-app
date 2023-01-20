package com.example.breakingbadapp.domain.repository

import androidx.paging.PagingData
import com.example.breakingbadapp.domain.model.Characters
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    fun getAllCharacters(): Flow<PagingData<Characters>>
    fun searchCharacters():Flow<PagingData<Characters>>
}