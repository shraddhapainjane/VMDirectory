package com.example.vmdirectory.di

import com.example.vmdirectory.data.remote.ApiService
import com.example.vmdirectory.data.remote.PeopleApiData
import com.example.vmdirectory.data.repository.PeopleRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit = Retrofit.Builder()
        .baseUrl("https://5f7c2c8400bd74001690a583.mockapi.io/api/v1/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Singleton
    @Provides
    fun providePeopleApiData(apiService: ApiService) = PeopleApiData(apiService)


    @Singleton
    @Provides
    fun provideRepository(remoteData: PeopleApiData) =
        PeopleRepository(remoteData)
}