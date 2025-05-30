package com.micahnyabuto.thera.data.remote

import retrofit2.http.Body
import retrofit2.http.POST

interface Thera {
    @POST("chat/")
    suspend fun sendMessage(@Body request: ChatRequest): ChatResponse
}
