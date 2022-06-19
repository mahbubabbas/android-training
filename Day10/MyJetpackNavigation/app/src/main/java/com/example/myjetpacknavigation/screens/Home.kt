package com.example.myjetpacknavigation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.myjetpacknavigation.NavRoutes

@Composable
fun Home(navController: NavHostController) {
    var userName by remember { mutableStateOf("") }

    val onUserNameChange = { text: String ->
        userName = text
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            CustomTextField(
                title = "Username",
                textState = userName,
                onTextChange = onUserNameChange
            )

            Spacer(modifier = Modifier.height(10.dp))

            Button(onClick = {
                navController.navigate(NavRoutes.Welcome.route + "/$userName")
            }) {
                Text(text = "Register")
            }
        }
    }
}

@Composable
fun CustomTextField(title: String, textState: String, onTextChange: (String) -> Unit) {
    TextField(
        value = textState,
        enabled = true,
        onValueChange = { onTextChange(it) },
        singleLine = true,
        modifier = Modifier
            .padding(start = 20.dp, top = 10.dp, bottom = 10.dp)
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.primary,
            ),
        textStyle = TextStyle(
            fontSize = 20.sp,
        )
    )
}
