package com.example.mycompose

import android.graphics.drawable.shapes.Shape
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycompose.ui.theme.MyComposeTheme
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Conversation(listMessages = messages)
                }
            }
        }
    }
}

data class Message(val author: String, val text: String)

@Composable
fun MessageCard(message: Message) {
    Column {
        Row {
            Image(
                painter = painterResource(id = R.drawable.user),
                contentDescription = "User Image",
                modifier = Modifier.padding(all = 10.dp)
            )
            Column(modifier = Modifier.padding(all = 10.dp)) {
                Text(
                    text = message.author,
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 15.sp,
                    fontWeight = FontWeight(700),
                )
                Text(
                    text = message.text,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        }
        Canvas(modifier = Modifier.fillMaxSize()) {
            // Fetching width and height for
            // setting start x and end y
            val canvasWidth = size.width
            val canvasHeight = size.height

            // drawing a line between start(x,y) and end(x,y)
            drawLine(
                start = Offset(x = canvasWidth, y = 0f),
                end = Offset(x = 0f, y = 0f),
                color = Color.Gray,
                alpha = 0.3f,
                strokeWidth = 3F
            )
        }
    }
}

@Composable
fun Conversation(listMessages: List<Message>) {
    LazyColumn {
        items(listMessages) { message ->
            MessageCard(message = message)
        }
    }
}

val messages = listOf<Message>(
    Message("Abbas", "Hi hello"),
    Message("Mahbub", "This is a test"),
    Message("Abbas", "Hi hello"),
    Message("Mahbub", "This is a test"),
    Message("Abbas", "Hi hello"),
    Message("Mahbub", "This is a test"),
    Message("Abbas", "Hi hello"),
    Message("Mahbub", "This is a test"),
    Message("Abbas", "Hi hello"),
    Message("Mahbub", "This is a test"),
    Message("Abbas", "Hi hello"),
    Message("Mahbub", "This is a test"),
    Message("Abbas", "Hi hello"),
    Message("Mahbub", "This is a test"),
    Message("Abbas", "Hi hello"),
    Message("Mahbub", "This is a test"),
    Message("Abbas", "Hi hello"),
    Message("Mahbub", "This is a test"),
    Message("Abbas", "Hi hello"),
    Message("Mahbub", "This is a test"),
    Message("Abbas", "Hi hello"),
    Message("Mahbub", "This is a test"),
    Message("Abbas", "Hi hello"),
    Message("Mahbub", "This is a test"),
    Message("Abbas", "Hi hello"),
    Message("Mahbub", "This is a test"),
    Message("Abbas", "Hi hello"),
    Message("Mahbub", "This is a test"),
    Message("Abbas", "Hi hello"),
    Message("Mahbub", "This is a test"),
    Message("Abbas", "Hi hello"),
    Message("Mahbub", "This is a test"),
)

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyComposeTheme {
        Conversation(listMessages = messages)
    }
}