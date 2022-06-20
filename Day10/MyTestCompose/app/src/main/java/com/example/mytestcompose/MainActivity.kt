package com.example.mytestcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.unit.dp
import com.example.mytestcompose.ui.theme.MyTestComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyTestComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MessageList(messages = messages)
                }
            }
        }
    }
}

data class Message(val author: String, val text: String)

@Composable
fun MessageCard(message: Message) {
    Column {
        Row(
            modifier = Modifier.padding(all = 8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile),
                modifier = Modifier
                    .height(40.dp)
                    .width(40.dp),
                contentDescription = null
            )

            Column(
                modifier = Modifier.padding(start = 10.dp)
            ) {
                Text(
                    text = message.author,
                    color = MaterialTheme.colors.primary,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = message.text,
                    fontSize = 12.sp,
                )
            }
        }

        Divider(
            thickness = 1.dp,
            color = androidx.compose.ui.graphics.Color.Gray,
        )
    }

}

@Composable
fun MessageList (messages : List<Message>) {
    LazyColumn {
        items(messages) { message ->
            MessageCard(message)
        }
    }
}

val messages = listOf<Message>(
    Message("Abbas", "How are you"),
    Message("Abbas", "How are you"),
    Message("Abbas", "How are you"),
    Message("Abbas", "How are you"),
    Message("Abbas", "How are you"),
    Message("Abbas", "How are you"),
    Message("Abbas", "How are you"),
    Message("Abbas", "How are you"),
    Message("Abbas", "How are you"),
    Message("Abbas", "How are you"),
    Message("Abbas", "How are you"),
    Message("Abbas", "How are you"),
    Message("Abbas", "How are you"),
    Message("Abbas", "How are you"),
    Message("Abbas", "How are you"),
    Message("Abbas", "How are you"),
    Message("Abbas", "How are you"),
    Message("Abbas", "How are you"),
    Message("Abbas", "How are you"),
    Message("Abbas", "How are you"),
    Message("Abbas", "How are you"),
    Message("Abbas", "How are you"),
    Message("Abbas", "How are you"),
    Message("Abbas", "How are you"),
    )


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyTestComposeTheme {
        MessageList(messages = messages)
    }
}
