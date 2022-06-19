package com.example.myjetpacknavigation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun Profile() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Text(
                "Profile Screen",
                style = MaterialTheme.typography.headlineSmall
            )
            Text(text = "Some dummy text about profile description")
        }
    }
}