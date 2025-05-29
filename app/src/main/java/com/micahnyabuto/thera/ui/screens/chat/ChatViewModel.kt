package com.micahnyabuto.thera.ui.screens.chat

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.micahnyabuto.thera.data.repository.ChatRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class ChatMessage(
    val isUser: Boolean,
    val message: String
)

@HiltViewModel
class ChatViewModel @Inject constructor(
    private val repository: ChatRepository
) : ViewModel() {

    private val _chatHistory = MutableStateFlow<List<ChatMessage>>(emptyList())
    val chatHistory: StateFlow<List<ChatMessage>> = _chatHistory

    fun sendMessage(userMessage: String) {
        Log.d("TheraBot", "User message: $userMessage")

        val currentHistory = _chatHistory.value.toMutableList()
        currentHistory.add(ChatMessage(isUser = true, message = userMessage))
        _chatHistory.value = currentHistory

        viewModelScope.launch {
            try {
                val response = repository.sendMessageToBot(userMessage)
                Log.d("TheraBot", "AI response: ${response.reply}")

                val updatedHistory = _chatHistory.value.toMutableList()
                updatedHistory.add(ChatMessage(isUser = false, message = response.reply))
                _chatHistory.value = updatedHistory
            } catch (e: Exception) {
                Log.e("TheraBot", "Error sending message: ${e.localizedMessage}", e)
            }
        }
    }

}

