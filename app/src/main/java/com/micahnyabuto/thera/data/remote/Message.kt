package com.micahnyabuto.thera.data.remote

data class Message(
    val id: Int,
    val title:String,
    val message: String,
    val response: String,
    val created_at: Long,
)
