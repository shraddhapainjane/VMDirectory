package com.example.vmdirectory.data.remote

import com.example.vmdirectory.data.model.People
import com.example.vmdirectory.data.model.Room
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("people")
    suspend fun getPeopleList() : Response<List<People>>

    @GET("rooms")
    suspend fun getRoomList(): Response<List<Room>>
}