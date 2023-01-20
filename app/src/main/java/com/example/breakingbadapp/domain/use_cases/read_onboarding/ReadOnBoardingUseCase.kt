package com.example.breakingbadapp.domain.use_cases.read_onboarding

import com.example.breakingbadapp.data.repository.Repository
import kotlinx.coroutines.flow.Flow


class ReadOnBoardingUseCase(
    private val repository: Repository
) {
    operator fun invoke(): Flow<Boolean>{
        return repository.readOnBoardingState()
    }
}