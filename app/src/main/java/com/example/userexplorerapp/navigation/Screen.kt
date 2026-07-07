package com.example.userexplorerapp.navigation

sealed class Screen(val route: String){
    object Home: Screen("home")

    object UserList: Screen("user_list")

    object UserDetail : Screen("user_detail")
}