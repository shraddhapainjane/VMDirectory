package com.example.vmdirectory.ui.room

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.vmdirectory.data.repository.PeopleRepository


class RoomViewModel @ViewModelInject constructor(
    private val repository: PeopleRepository
) : ViewModel() {

    val rooms = repository.getRoomListData()
}