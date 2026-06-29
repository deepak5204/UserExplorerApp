package com.example.userexplorerapp

import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.userexplorerapp.ui.theme.UserExplorerAppTheme
import com.example.userexplorerapp.viewmodel.UserViewModel

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
    val context = LocalContext.current

    val infoTextStyle = MaterialTheme.typography.bodyLarge.copy(
        fontSize = 16.sp
    )
    if (uiState.isLoading) {

        Box(
            modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else if (uiState.error != null) {
        Toast.makeText(context, uiState.error, Toast.LENGTH_SHORT).show()
    } else {
        val userList = uiState.users

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(userList.size) { index ->
                val user = userList[index];

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(6.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {

                                AsyncImage(
                                    model = "https://i.pravatar.cc/150?img=${user.id}",
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(72.dp)
                                        .clip(CircleShape),
                                    contentScale = ContentScale.Fit
                                )
//                            Icon(imageVector = Icons.Default.Person, contentDescription = "profile")
                            Column {
                                Text(text = user.name, style = infoTextStyle)
                                Text(text = user.username, style = infoTextStyle)
                            }
                        }


                        Row(
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Email, contentDescription = "email"
                            )
                            Text(text = user.email, style = infoTextStyle)
                        }

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Phone, contentDescription = "phone"
                            )
                            Text(text = user.phone, style = infoTextStyle)
                        }

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Build, contentDescription = "websites"
                            )
                            Text(
                                text = user.website,
                                style = infoTextStyle,
                                color = Color.Blue,
                                modifier = Modifier.clickable {
                                    val intent = Intent(
                                        ACTION_VIEW, "https://${user.website}".toUri()
                                    )
                                    context.startActivity(intent)
                                })
                        }

                        Column {
                            Row(
                                modifier = Modifier.clickable {
                                    val lat = user.address.geo.lat
                                    val lng = user.address.geo.lng

                                    val uri = "https://maps.google.com/?q=$lat,$lng".toUri()
                                    val intent = Intent(
                                        Intent.ACTION_VIEW, uri
                                    ).apply {
                                        setPackage("com.google.android.apps.maps")
                                    }

                                    if (intent.resolveActivity(context.packageManager) != null) {
                                        context.startActivity(intent)
                                    } else {
                                        val browserIntent = Intent(
                                            Intent.ACTION_VIEW,
                                            "https://www.google.com/maps/dir/?api=1&destination=$lat,$lng".toUri()
                                        )
                                        context.startActivity(browserIntent)
                                    }

                                    context.startActivity(intent)
                                }, horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.LocationOn,
                                    contentDescription = "Location"
                                )

                                Column {
                                    Text(text = user.address.city, color = Color.Blue)
                                    Row(
                                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                                    ) {
                                        Text(user.address.street, style = infoTextStyle)
                                        Text(text = user.address.suite, style = infoTextStyle)
                                    }
                                }


                            }

                        }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UserExplorerAppTheme {
        UserScreen(viewModel = viewModel())
    }
}