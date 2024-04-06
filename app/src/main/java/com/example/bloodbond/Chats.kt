package com.example.bloodbond

import android.graphics.Paint.Style
import android.os.Message
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bloodbond.R
import com.example.bloodbond.ui.theme.TabItem
import com.google.firebase.Firebase


@Composable
fun Chats() {
    Box(
        modifier = Modifier.fillMaxSize(),

    ) {
        ChatScreen(
            chatMessages = listOf<ChatMessage>(
                ChatMessage(
                    R.drawable.profile2,
                    "Maciej Kowalski",
                    "maciej.kowalski@email.com",
                    "08:45",
                    true
                ),
                ChatMessage(
                    R.drawable.post2_profile,
                    "Odeusz Piotrowski",
                    "Will do, super, thank you",
                    "08:45",
                    true
                ),
                ChatMessage(
                    R.drawable.post1_profile,
                    "Bożenka Malina",
                    "Uploaded file.",
                    "08:45",
                    true
                ),
                ChatMessage(
                    R.drawable.post2_profile,
                    "Maciej Orłowski",
                    "Here is another tutorial, if you...",
                    "08:45",
                    true
                ),
                ChatMessage(
                    R.drawable.post1_profile,
                    "Krysia Eurydyka",
                    "no pracujemy z domu przez 5 ...",
                    "08:45",
                    true
                ),
                ChatMessage(
                    R.drawable.post2_profile,
                    "MC Bastek",
                    "no pracujemy z domu przez 5 ...",
                    "08:45",
                    true
                ),
                ChatMessage(
                    R.drawable.profile2,
                    "Marzena Klasa",
                    "potem sie zobaczy",
                    "08:45",
                    true
                ),
                ChatMessage(
                    R.drawable.post1_profile,
                    "mis_potter",
                    "Ashok is a very good person",
                    "08:45",
                    true
                ),
                ChatMessage(
                    R.drawable.post1_profile,
                    "Lavis Eran",
                    "Ashok is a very good person",
                    "08:45",
                    true
                ),
                ChatMessage(
                    R.drawable.post1_profile,
                    "mis_potter",
                    "Ashok is a very good person",
                    "08:45",
                    true
                ),
                ChatMessage(
                    R.drawable.post1_profile,
                    "mis_potter",
                    "Ashok is a very good person",
                    "08:45",
                    true
                ),
            )
        )
    }
}



@Composable
fun ChatScreen(chatMessages: List<ChatMessage>) {
    var search by rememberSaveable {
        mutableStateOf("")
    }
    Column (
        modifier = Modifier
            .fillMaxSize()
    ){
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ){
            OutlinedTextField(
                value = search,
                onValueChange = { search = it },
                shape = RoundedCornerShape(15.dp),
                enabled = true,
                label = {
                    Text(
                        text = "Search... ",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontFamily = custom_fontFamily,
                            fontSize = 15.sp,
                            textAlign = TextAlign.Center
                        )
                    )
                },
                modifier = Modifier.fillMaxWidth(0.67f),

            )
            Spacer(modifier = Modifier.width(10.dp))
            ExtendedFloatingActionButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .size(50.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.search_icon),
                    contentDescription = search,
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
            Spacer(modifier = Modifier.width(5.dp))
            ExtendedFloatingActionButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .size(50.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.new_chat),
                    contentDescription = search
                )
            }
        }
        LazyColumn(
            modifier = Modifier
        ) {
            items(chatMessages) { message ->
                ChatItem(message)
            }
        }
    }
}

@Composable
fun ChatItem(message: ChatMessage) {
    Button(
        onClick = { /*TODO*/ },
        shape  = RoundedCornerShape(20.dp),
        modifier= Modifier
            .fillMaxWidth()
            .height(80.dp),
        colors = ButtonDefaults.buttonColors(  // Use default button colors
            containerColor = Color.White,
            contentColor = Color.Black // Set background color to white
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = message.profilePic),
                contentDescription = null,
                modifier = Modifier
                    .size(55.dp)
                    .shadow(7.dp, CircleShape),
                contentScale = ContentScale.Crop,
                alignment = Alignment.CenterStart
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Column(
                    modifier = Modifier.padding(start = 16.dp)
                ) {
                    Text(
                        text = message.senderName,
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontFamily = custom_fontFamily,
                            fontSize = 17.sp
                        )
                    )
                    Text(
                        text = message.content,
                        style = TextStyle(
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = custom_fontFamily,
                            fontSize = 15.sp
                        )
                    )
                }
                Column (
                    modifier = Modifier
                ){
                    Text(
                        text = message.timestamp,
                        color = Color(0xFF26A586),
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontFamily = custom_fontFamily,
                            fontSize = 15.sp
                        )
                    )
                    if (message.isNew) {
                        Box(
                            modifier = Modifier
                                .size(18.dp)
                                .clip(shape = RoundedCornerShape(10.dp))
                                .align(Alignment.CenterHorizontally)
                                .background(Color(0xFF26A586), CircleShape)
                        ){
                            Text(text = "11",
                                style = TextStyle(
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = custom_fontFamily,
                                    fontSize = 12.sp,
                                    textAlign = TextAlign.Center
                                ),
                                modifier = Modifier
                                    .fillMaxSize()
                            )
                        }
                    }
                }
            }
        }
    }
}

// Define data model for chat message
data class ChatMessage(
    val profilePic: Int, // Resource ID for profile picture
    val senderName: String,
    val content: String,
    val timestamp: String,
    val isNew: Boolean
)

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DisplayChats(){
    ChatScreen(
        chatMessages = listOf<ChatMessage>(
            ChatMessage(
                R.drawable.post1_profile,
                "mis_potter",
                "Ashok is a very good person",
                "08:45",
                true
            ),
            ChatMessage(
                R.drawable.post1_profile,
                "mis_potter",
                "Ashok is a very good person",
                "08:45",
                true
            ),
        )
    )
}