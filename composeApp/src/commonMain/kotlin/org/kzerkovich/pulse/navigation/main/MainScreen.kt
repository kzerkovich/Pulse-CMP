package org.kzerkovich.pulse.navigation.main

import AppScreens
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.resources.stringResource
import org.kzerkovich.pulse.features.feed.ui.FeedScreen
import org.kzerkovich.pulse.features.profile.ui.ProfileScreen
import org.kzerkovich.pulse.navigation.LocalNavHost
import org.kzerkovich.pulse.theme.PulseTheme
import pulse.composeapp.generated.resources.Res
import pulse.composeapp.generated.resources.bottom_home
import pulse.composeapp.generated.resources.bottom_inbox
import pulse.composeapp.generated.resources.bottom_library
import pulse.composeapp.generated.resources.bottom_post
import pulse.composeapp.generated.resources.bottom_subscriptions

enum class MainScreens(val route: String) {
    Home("home"),
    Subscriptions("subscriptions"),
    Post("post"),
    Inbox("inbox"),
    Library("library")
}

@Composable
fun MainScreen() {
    val outerNavController = LocalNavHost.current
    val navController = rememberNavController()
    val items = MainScreens.entries.toTypedArray()

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        NavHost(
            navController = navController,
            modifier = Modifier
                .padding(bottom = 75.dp)
                .fillMaxHeight(),
            startDestination = MainScreens.Home.route
        ) {
            composable(MainScreens.Home.route) {
                FeedScreen()
            }
            composable(MainScreens.Subscriptions.route) {
                ProfileScreen()
            }
            composable(MainScreens.Inbox.route) {
                Text("Hello, inbox")
            }
            composable(MainScreens.Library.route) {
                Text("Hello, library")
            }
        }

        BottomNavigation(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .fillMaxWidth()
                .height(75.dp),
            backgroundColor = PulseTheme.colors.secondaryBackground
        ) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination

            items.forEach { screen ->
                val isSelected =
                    currentDestination?.hierarchy?.any { it.route == screen.route } == true

                BottomNavigationItem(
                    icon = {
                        Icon(
                            imageVector = when (screen) {
                                MainScreens.Home -> Icons.Filled.Home
                                MainScreens.Subscriptions -> Icons.Filled.Check
                                MainScreens.Post -> Icons.Filled.Add
                                MainScreens.Inbox -> Icons.Filled.MailOutline
                                MainScreens.Library -> Icons.Filled.AccountBox
                            },
                            contentDescription = screen.route,
                            tint = if (isSelected) PulseTheme.colors.primaryText else PulseTheme.colors.tintColor
                        )
                    },
                    label = {
                        Text(
                            text = stringResource(
                                when (screen) {
                                    MainScreens.Home -> Res.string.bottom_home
                                    MainScreens.Subscriptions -> Res.string.bottom_subscriptions
                                    MainScreens.Post -> Res.string.bottom_post
                                    MainScreens.Inbox -> Res.string.bottom_inbox
                                    MainScreens.Library -> Res.string.bottom_library
                                }
                            ),
                            color = if (isSelected) PulseTheme.colors.primaryText else PulseTheme.colors.tintColor
                        )
                    },
                    selected = isSelected,
                    onClick = {
                        if (screen == MainScreens.Post) {
                            outerNavController.navigate(AppScreens.CreatePost.title)
                        } else {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().displayName) {
                                    saveState = true
                                }

                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    }
                )
            }
        }
    }
}