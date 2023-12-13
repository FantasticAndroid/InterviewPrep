package com.offline.first.compose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.offline.first.ui.theme.OfflineFirstDemoTheme

class NotifCounterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OfflineFirstDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    previewCompose()
                }
            }
        }
    }
}

/**
 * Its is StateFull Composable
 */
@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun previewCompose() {
    // Concept of State Hoisting
    val count = remember {
        mutableIntStateOf(0)
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(1f)
    ) {
        NotificationCounter(count.intValue){
            count.intValue++
        }
        MessageBar(count.intValue)
    }
}

/**
 * Concept of Remember State
 * Its is Stateless Composable
 */
@Composable
fun NotificationCounter(countValue: Int, onBtnClick: () -> Int) {

    /**
     * It save state in Bundle nor compose state
     */
    val countSavedInstanceStateForOrientation = rememberSaveable {
        mutableIntStateOf(0)
    }
    Log.d("NotifCounter F", "Count: $countValue")
    Column {
        Text(text = "Sent $countValue Notification")
        Button(onClick = {
            onBtnClick()
            Log.d("NotifCounter C", "Count: $countValue")
        }) {
            Text(text = "Send Message")
        }
    }
}

/**
 * Its is Stateless Composable
 */
@Composable
fun MessageBar(countValue: Int) {
    Card {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(6.dp)
        ) {
            Image(
                imageVector = Icons.Outlined.Favorite,
                contentDescription = "Message",
                modifier = Modifier.padding(4.dp)
            )
            Text(text = "Message Sent for $countValue Notification")
        }
    }
}
