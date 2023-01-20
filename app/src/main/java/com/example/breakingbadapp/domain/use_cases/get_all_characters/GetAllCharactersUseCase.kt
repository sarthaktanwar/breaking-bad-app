package com.example.breakingbadapp.domain.use_cases.get_all_characters

import androidx.paging.PagingData
import com.example.breakingbadapp.data.repository.Repository
import com.example.breakingbadapp.domain.model.Characters
import kotlinx.coroutines.flow.Flow

class GetAllCharactersUseCase(
    private val repository: Repository
) {
    operator fun invoke():Flow<PagingData<Characters>>{
       return repository.getAllCharacters()
    }
}