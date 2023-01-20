package com.example.breakingbadapp.presentation.screen.welcome

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.breakingbadapp.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject constructor(
    private val usecases: UseCases
): ViewModel(){
    fun saveOnBoardingState(completed : Boolean){
        viewModelScope.launch(Dispatchers.IO) {
            usecases.saveOnBoardingUseCase(completed = completed)
        }
    }

}