package com.example.breakingbadapp.di

import android.content.Context
import com.example.breakingbadapp.data.repository.DataStoreOperationsImpl
import com.example.breakingbadapp.data.repository.Repository
import com.example.breakingbadapp.domain.repository.DataStoreOperations
import com.example.breakingbadapp.domain.use_cases.UseCases
import com.example.breakingbadapp.domain.use_cases.get_all_characters.GetAllCharactersUseCase
import com.example.breakingbadapp.domain.use_cases.read_onboarding.ReadOnBoardingUseCase
import com.example.breakingbadapp.domain.use_cases.save_onboarding.SaveOnBoardingUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDataStoreOperation(
        @ApplicationContext context: Context
    ):DataStoreOperations{
        return DataStoreOperationsImpl(context = context)

    }
    @Provides
    @Singleton
    fun provideUseCases(repository: Repository):UseCases{
        return UseCases(
            saveOnBoardingUseCase = SaveOnBoardingUseCase(repository),
            readOnBoardingUseCase = ReadOnBoardingUseCase(repository),
            getAllCharactersUseCase = GetAllCharactersUseCase(repository )
        )
    }
}