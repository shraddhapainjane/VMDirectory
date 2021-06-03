package com.example.vmdirectory.data.repository

import com.example.vmdirectory.data.remote.PeopleApiData
import com.example.vmdirectory.utils.callGetService
import javax.inject.Inject

class PeopleRepository @Inject constructor(
    private val remoteData: PeopleApiData
) {

    fun getRoomListData() = callGetService(
        networkCall = { remoteData.getRoomListData() }
    )

    fun getPeopleListData() = callGetService(
        networkCall = { remoteData.getPeopleListData() }
    )
}