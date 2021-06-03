package com.example.vmdirectory.data.remote

import javax.inject.Inject

class PeopleApiData @Inject constructor(
    private val apiService: ApiService
): BaseNetworkData() {

    suspend fun getPeopleListData() = getResponseData { apiService.getPeopleList() }

    suspend fun getRoomListData() = getResponseData { apiService.getRoomList() }
}