package com.micahnyabuto.thera.ui.navigation

import kotlinx.serialization.Serializable

sealed class Destinations {
    @Serializable
    object Home

    @Serializable
    object Chat

    @Serializable
    object Profile

    @Serializable
    object Settings

    @Serializable
    object Splash
}