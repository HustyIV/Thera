package com.micahnyabuto.thera.data.repository

import com.micahnyabuto.thera.data.remote.ChatRequest
import com.micahnyabuto.thera.data.remote.ChatResponse
import com.micahnyabuto.thera.data.remote.Thera
import javax.inject.Inject

class ChatRepository @Inject constructor(
    private val api: Thera
) {
    suspend fun sendMessageToBot(message: String): ChatResponse {
        return api.sendMessage(ChatRequest(message))
    }
}

