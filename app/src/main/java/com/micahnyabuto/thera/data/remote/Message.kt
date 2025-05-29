package com.micahnyabuto.thera.data.remote

data class ChatRequest(
    val message: String
)

data class ChatResponse(
    val reply: String
)

