package com.offline.first.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.offline.first.ui.theme.OfflineFirstDemoTheme

class ThemeDemoActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WithTheme()
        }
    }

    @Composable
    private fun WithTheme(){
        val themeState = remember {
            mutableStateOf(false)
        }

        OfflineFirstDemoTheme(darkTheme = themeState.value) {
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                ApplyWithTheme(themeState)
            }
        }
    }

    @Composable
    private fun ApplyWithTheme(themeState: MutableState<Boolean>) {

        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
            Text(
                text = "Theme Switch Example",
                modifier = Modifier.background(MaterialTheme.colorScheme.background),
                style = if (themeState.value) MaterialTheme.typography.titleLarge else MaterialTheme.typography.titleSmall
            )
            Button(onClick = {
                themeState.value = !themeState.value
            }) {
                Text(text = if (themeState.value) "Large" else "Small")
            }
        }
    }

    @Preview(showSystemUi = true, showBackground = true)
    @Composable
    private fun previewCompose() {
        WithTheme()
    }
}