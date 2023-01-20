

package com.example.breakingbadapp.di

import androidx.paging.ExperimentalPagingApi
import com.example.breakingbadapp.data.local.BreakingBadDatabase
import com.example.breakingbadapp.data.remote.BreakingBadApi
import com.example.breakingbadapp.data.repository.RemoteDataSourceImpl
import com.example.breakingbadapp.domain.repository.RemoteDataSource
import com.example.breakingbadapp.navigation.util.Constants.BASE_URL
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@ExperimentalPagingApi
@ExperimentalSerializationApi
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideHttpClient():OkHttpClient{
        return OkHttpClient.Builder()
            .readTimeout(15,TimeUnit.MINUTES)
            .connectTimeout(15,TimeUnit.MINUTES)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofitInstance(okHttpClient: OkHttpClient):Retrofit{

        // check for error latter
        val contentType = "application/json".toMediaType()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(Json.asConverterFactory(contentType))
            .build()

    }
    @Provides
    @Singleton
    fun provideBreakingBadApi(retrofit: Retrofit):BreakingBadApi {
       return  retrofit.create(BreakingBadApi::class.java)
    }
    @Provides
    @Singleton
    fun provideRemoteDataSource(
        breakingBadApi: BreakingBadApi,
        breakingBadDatabase: BreakingBadDatabase
    ):RemoteDataSource{
        return RemoteDataSourceImpl(
            breakingBadApi = breakingBadApi,
            breakingBadDatabase =breakingBadDatabase
        )
    }

}