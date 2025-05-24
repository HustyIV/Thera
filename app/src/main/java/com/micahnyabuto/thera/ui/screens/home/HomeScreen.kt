package com.micahnyabuto.thera.ui.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.micahnyabuto.thera.ui.navigation.Destinations

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController
){
    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Text("Chats")
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Default.Notifications,
                            contentDescription = "notifications"
                        )
                    }
                }
            )
        }
    ){innerpadding ->
        Card(
            modifier = Modifier.padding(start = 10.dp,top= 100.dp, end = 10.dp)
                .clickable{navController.navigate(Destinations.Chat)}
                .height(50.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(2.dp)

        ) {

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Today",
                    modifier = Modifier.padding(start = 4.dp))
            }

        }

    }
}