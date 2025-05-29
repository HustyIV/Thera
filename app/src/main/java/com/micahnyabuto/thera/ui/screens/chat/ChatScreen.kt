package com.micahnyabuto.thera.ui.screens.chat

import android.annotation.SuppressLint
import android.graphics.Paint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.micahnyabuto.thera.ui.navigation.Destinations
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.micahnyabuto.thera.ui.theme.PrimaryColor


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreen(
    viewModel: ChatViewModel = hiltViewModel(),
    navController: NavController,
) {
    val chatHistory by viewModel.chatHistory.collectAsState()
    var userMessage by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Chat with Thera") },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate(Destinations.Home)
                    }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBackIos,
                            contentDescription = "Navigate up"
                        )
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                tonalElevation = 3.dp
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp, vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedTextField(
                        value = userMessage,
                        onValueChange = { userMessage = it },
                        placeholder = { Text("Start chat here...") },
                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 8.dp),
                        shape = RoundedCornerShape(50),
                        maxLines = 4
                    )

                    IconButton(
                        onClick = {
                            if (userMessage.isNotBlank()) {
                                viewModel.sendMessage(userMessage)
                                userMessage = ""
                            }
                        },
                        modifier = Modifier
                            .size(48.dp)
                            .background(MaterialTheme.colorScheme.primary, CircleShape)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Send,
                            contentDescription = "Send",
                            tint = Color.White
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            reverseLayout = true
        ) {
            items(chatHistory.reversed()) { chat ->
                val alignment = if (chat.isUser) Alignment.End else Alignment.Start
                val backgroundColor = if (chat.isUser) Color(0xFF64B5F7) else Color(0xFFDCF8C6)

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    contentAlignment = Alignment.TopEnd
                ) {
                    Text(
                        text = chat.message,
                        modifier = Modifier
                            .background(backgroundColor, shape = RoundedCornerShape(12.dp))
                            .padding(12.dp)
                            .widthIn(max = 280.dp),
                        color = Color.Black
                    )
                }
            }
        }
    }
}
