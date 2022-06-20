package com.example.myviewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myviewmodel.ui.theme.MyViewModelTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyViewModelTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen(viewModel: MyViewModel = viewModel()) {
    MainView(count = viewModel.counter) {
        viewModel.incrementCounter()
    }
}

@Composable
fun MainView(count: Int, increment: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "$count", fontSize = 30.sp)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = increment) {
            Text(text = "Increment")
        }
    }
}

class MyViewModel : ViewModel() {
    var counter by mutableStateOf(0)

    fun incrementCounter() {
        counter++
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyViewModelTheme {
        MainScreen()
    }
}