package org.kzerkovich.pulse.features.splash

import AppScreens
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import org.kzerkovich.pulse.features.splash.models.SplashAction

@Composable
fun SplashScreen(
    viewModel: SplashViewModel = viewModel { SplashViewModel() },
    navController: NavController
) {
    val viewAction by viewModel.viewActions().collectAsState(null)

    when (viewAction) {
        SplashAction.ShowLoginScreen -> navController.navigate(AppScreens.Login.title)
        SplashAction.ShowMainScreen -> navController.navigate(AppScreens.Main.title)
        null -> {}
    }
}