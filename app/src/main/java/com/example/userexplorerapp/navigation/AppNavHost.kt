package com.example.userexplorerapp.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.userexplorerapp.presentation.screen.HomeScreen
import com.example.userexplorerapp.presentation.screen.UserScreen
import com.example.userexplorerapp.presentation.viewmodel.UserViewModel

@Composable
fun AppNavHost(){
    val navController = rememberNavController()
    val viewModel: UserViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {

        composable(Screen.Home.route) {
            HomeScreen(
                onExploreUsersClick = {
                    navController.navigate(Screen.UserList.route)
                }
            )
        }

        composable(Screen.UserList.route) {
            UserScreen(viewModel = viewModel)
        }

        composable(Screen.UserDetail.route) {
            // UserDetailScreen()
        }
    }

}