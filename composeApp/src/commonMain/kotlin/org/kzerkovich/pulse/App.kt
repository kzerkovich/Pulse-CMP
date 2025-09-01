package org.kzerkovich.pulse

import AppScreens
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.kzerkovich.pulse.features.create.CreatePostScreen
import org.kzerkovich.pulse.features.login.LoginScreen
import org.kzerkovich.pulse.features.paywall.PaywallScreen
import org.kzerkovich.pulse.navigation.LocalNavHost
import org.kzerkovich.pulse.navigation.main.MainScreen
import org.kzerkovich.pulse.theme.AppTheme

@Preview
@Composable
internal fun App() = AppTheme {
    PulseApp()
}

@Composable
internal fun PulseApp(
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = backStackEntry?.destination?.route ?: AppScreens.Login.title

    CompositionLocalProvider(
        LocalNavHost provides navController
    ) {
        NavHost(
            navController = navController,
            startDestination = currentScreen
        ) {
            composable(route = AppScreens.Login.title) {
                LoginScreen()
            }
            composable(route = AppScreens.Main.title) {
                MainScreen()
            }
            composable(route = AppScreens.CreatePost.title) {
                CreatePostScreen()
            }
            composable(route = AppScreens.Paywall.title) {
                PaywallScreen()
            }
        }
    }
}
