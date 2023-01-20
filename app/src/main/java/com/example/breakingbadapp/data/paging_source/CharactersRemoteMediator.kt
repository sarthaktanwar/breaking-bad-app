package com.example.breakingbadapp.data.paging_source

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.breakingbadapp.data.local.BreakingBadDatabase
import com.example.breakingbadapp.data.remote.BreakingBadApi
import com.example.breakingbadapp.domain.model.Characters
import com.example.breakingbadapp.domain.model.CharactersRemoteKeys
import javax.inject.Inject

@ExperimentalPagingApi
class CharactersRemoteMediator @Inject constructor(
    private val breakingBadApi : BreakingBadApi,
    private val breakingbadDatabase: BreakingBadDatabase

) : RemoteMediator<Int,Characters>() {

    private val charactersDao = breakingbadDatabase.charactersDao()
    private val characterRemoteKeyDao = breakingbadDatabase.charactersRemoteKeyDao()


    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, Characters>
    ): MediatorResult {
       return try{
           val page = when(loadType){
               LoadType.REFRESH->{
                   val remoteKeys = getRemoteKeyClosestToCurrentPosition(state)
                   remoteKeys?.nextPage?.minus(1)?:1
               }
               LoadType.PREPEND->{
                   val remoteKeys = getRemoteKeyFirstItem(state)
                   val prevPage = remoteKeys?.prevPage
                       ?:return MediatorResult.Success(
                           endOfPaginationReached = remoteKeys != null
                       )
                   prevPage
               }
               LoadType.APPEND->{
                   val remoteKeys = getRemoteKeysForLastItem(state)
                   val nextPage = remoteKeys?.nextPage
                       ?:return MediatorResult.Success(
                           endOfPaginationReached = remoteKeys != null
                       )
                   nextPage
               }
           }
           val response = breakingBadApi.getAllCharacters(page = page)
           if(response.characters.isNotEmpty()){
                breakingbadDatabase.withTransaction {
                    if(loadType == LoadType.REFRESH){
                        charactersDao.deleteAllCharacters()
                        characterRemoteKeyDao.deleteAllRemoteKeys()

                    }
                    val prevPage = response.prevPage
                    val nextPage = response.nextPage
                    val keys = response.characters.map {character->
                        CharactersRemoteKeys(
                            id =character.id,
                            prevPage = prevPage,
                            nextPage = nextPage
                        )
                    }
                    characterRemoteKeyDao.addAllRemoteKeys(charactersRemoteKey = keys)
                    charactersDao.addCharacters(charactersList = response.characters)
                }

           }
           MediatorResult.Success(endOfPaginationReached = response.nextPage == null)



       }
       catch (e: Exception){
           return MediatorResult.Error(e)

       }
    }
    private suspend fun getRemoteKeysForLastItem(state: PagingState<Int, Characters>): CharactersRemoteKeys? {
        return state.pages.lastOrNull { it.data.isNotEmpty() }?.data?.lastOrNull()
            ?.let { characters ->
                characterRemoteKeyDao.getRemoteKeys(id = characters.id)
            }

    }

    private suspend fun getRemoteKeyClosestToCurrentPosition(state: PagingState<Int, Characters>): CharactersRemoteKeys? {
       return state.anchorPosition?.let { position->
           state.closestItemToPosition(position)?.id?.let { id->
               characterRemoteKeyDao.getRemoteKeys(id = id)
           }
       }
    }
    private suspend fun getRemoteKeyFirstItem(state: PagingState<Int, Characters>): CharactersRemoteKeys? {
        return state.pages.firstOrNull { it.data.isNotEmpty()  }?.data?.firstOrNull()
            ?.let { characters ->
                characterRemoteKeyDao.getRemoteKeys(id = characters.id)
            }


        }
    }
//}