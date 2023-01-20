package com.example.breakingbadapp.domain.use_cases.save_onboarding

import com.example.breakingbadapp.data.repository.Repository

class SaveOnBoardingUseCase(
    private val repository : Repository
) {
    suspend operator fun invoke(completed: Boolean){
        repository.saveOnBoardingState(completed = completed)
    }

}