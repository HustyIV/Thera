package com.micahnyabuto.thera.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

enum class BottomNavigation(
    val label: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val route: Any
) {
    Home(
        label = "Chats",
        selectedIcon = Icons.Default.Chat,
        unselectedIcon = Icons.Default.Chat,
        route = Destinations.Home
    ),
    Profile(
        label = "Profile",
        selectedIcon = Icons.Default.Person,
        unselectedIcon = Icons.Default.Person,
        route = Destinations.Profile
    ),
    Settings(
        label = "Settings",
        selectedIcon = Icons.Default.Settings,
        unselectedIcon = Icons.Default.Settings,
        route = Destinations.Settings
    )
}