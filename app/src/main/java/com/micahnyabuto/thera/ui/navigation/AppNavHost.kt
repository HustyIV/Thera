package com.micahnyabuto.thera.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.micahnyabuto.thera.ui.screens.chat.HomeScreen
import com.micahnyabuto.thera.ui.screens.profile.ProfileScreen
import com.micahnyabuto.thera.ui.screens.settings.SettingsScreen
import com.micahnyabuto.thera.ui.screens.splash.SplashScreen

@Composable
fun AppNavHost(
    modifier: Modifier= Modifier,
    navController: NavHostController
){
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Destinations.Splash
    ) {
        composable <Destinations.Splash>{
            SplashScreen(
                onSplashFinished = {
                    navController.navigate(Destinations.Home){
                        popUpTo(Destinations.Splash){
                            inclusive =true
                        }
                    }
                }
            )
        }
        composable <Destinations.Home>{
            HomeScreen()
        }

        composable <Destinations.Profile>{
            ProfileScreen()
        }

        composable <Destinations.Settings>{
            SettingsScreen(
                viewModel = viewModel()
            )
        }


    }
}