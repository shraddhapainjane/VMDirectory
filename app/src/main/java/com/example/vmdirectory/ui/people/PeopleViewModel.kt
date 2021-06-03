package com.example.vmdirectory.ui.people

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.vmdirectory.data.repository.PeopleRepository


class PeopleViewModel @ViewModelInject constructor(
    private val repository: PeopleRepository
) : ViewModel() {

    val people = repository.getPeopleListData()
}