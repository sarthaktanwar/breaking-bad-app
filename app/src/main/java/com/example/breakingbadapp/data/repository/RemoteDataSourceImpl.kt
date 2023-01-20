package com.example.breakingbadapp.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.breakingbadapp.data.local.BreakingBadDatabase
import com.example.breakingbadapp.data.paging_source.CharactersRemoteMediator
import com.example.breakingbadapp.data.remote.BreakingBadApi
import com.example.breakingbadapp.domain.model.Characters
import com.example.breakingbadapp.domain.repository.RemoteDataSource
import com.example.breakingbadapp.navigation.util.Constants.ITEMS_PER_PAGE
import kotlinx.coroutines.flow.Flow


@ExperimentalPagingApi
class RemoteDataSourceImpl(
    private val breakingBadApi: BreakingBadApi,
    private val breakingBadDatabase: BreakingBadDatabase
):RemoteDataSource {

    private val charactersDao = breakingBadDatabase.charactersDao()

    override fun getAllCharacters(): Flow<PagingData<Characters>> {
     val pagingSourceFactory = {charactersDao.getAllCharacters()}
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            remoteMediator = CharactersRemoteMediator(
                breakingBadApi = breakingBadApi,
                breakingbadDatabase = breakingBadDatabase
            ),
            pagingSourceFactory =pagingSourceFactory
        ).flow
    }

    override fun searchCharacters(): Flow<PagingData<Characters>> {
        TODO("Not yet implemented")
    }


}
