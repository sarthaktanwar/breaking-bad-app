package com.example.breakingbadapp.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.breakingbadapp.data.local.BreakingBadDatabase
import com.example.breakingbadapp.navigation.util.Constants.BREAKING_BAD_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): BreakingBadDatabase {
        return Room.databaseBuilder(
            context,
            BreakingBadDatabase::class.java,
            BREAKING_BAD_DATABASE
        ).build()
    }
}