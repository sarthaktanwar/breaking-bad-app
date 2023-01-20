package com.example.breakingbadapp.data.repository

import androidx.datastore.dataStore
import androidx.paging.PagingData
import com.example.breakingbadapp.domain.model.Characters
import com.example.breakingbadapp.domain.repository.DataStoreOperations
import com.example.breakingbadapp.domain.repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val remote: RemoteDataSource,
    private val dataStore : DataStoreOperations
){
    fun getAllCharacters(): Flow<PagingData<Characters>>{
        return remote.getAllCharacters()
    }
    suspend fun saveOnBoardingState(completed: Boolean) {
        dataStore.saveOnBoardingState(completed = completed)
    }
    fun readOnBoardingState(): Flow<Boolean>{
        return dataStore.readOnBoardingState()
    }

}