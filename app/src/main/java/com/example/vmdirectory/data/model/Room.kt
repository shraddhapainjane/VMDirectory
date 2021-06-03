package com.example.vmdirectory.data.model

data class Room(
    val created_at: String,
    val name: String,
    val max_occupancy: String,
    val is_occupied: Boolean,
    val id: Int
)