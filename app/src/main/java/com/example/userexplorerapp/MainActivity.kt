package com.example.userexplorerapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.userexplorerapp.network.RetrofitInstance
import com.example.userexplorerapp.ui.theme.UserExplorerAppTheme
import com.example.userexplorerapp.viewmodel.UserViewModel
import kotlinx.coroutines.launch
import java.lang.Exception

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val viewModel: UserViewModel = viewModel() // bcz viewModel() is a composable function
            UserExplorerAppTheme {
                    UserScreen(
                        viewModel = viewModel
                    )
            }
        }
    }
}

@Composable
fun UserScreen(viewModel: UserViewModel) {
    val uiState by viewModel.uiState.collectAsState()
    Text("Users size: ${uiState.users.size}")

}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UserExplorerAppTheme {
        UserScreen(viewModel = viewModel())
    }
}