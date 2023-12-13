package com.offline.first.compose.sideeffect

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.offline.first.ui.theme.OfflineFirstDemoTheme
import kotlinx.coroutines.delay

private const val TAG = "ProduceDerivedSideEffect"

class ProduceDerivedSideEffectDemoActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WithSideEffect()
        }
    }

    @Composable
    private fun WithSideEffect() {
        OfflineFirstDemoTheme() {
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                Column(
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    WithoutProduceStateSideEffect()
                    WithProduceStateSideEffect()
                    ProduceStateDemo()
                    DerivedStateSideEffect()
                }
            }
        }
    }

    @Composable
    private fun WithoutProduceStateSideEffect() {

        val state = remember { mutableStateOf(0) }
        LaunchedEffect(key1 = Unit) {
            Log.d(TAG, "LaunchedEffect Stared")

            (1..100).forEach {
                delay(1000)
                state.value = it
            }
        }
        Text(text = "ChangeWPState: ${state.value}")
    }

    @Composable
    private fun WithProduceStateSideEffect() {

        val state = produceState(initialValue = 0) {
            Log.d(TAG, "produceState Stared")

            (1..100).forEach {
                delay(1000)
                value = it
            }
        }

        Text(text = "ChangePState: ${state.value}")
    }

    @Composable
    private fun ProduceStateDemo(){
        val state = produceState(initialValue = 0) {
            while (true) {
                delay(16)
                value = (value + 10) % 360
            }
        }

        Box(contentAlignment = Alignment.Center) {
            Column {
                Image(
                    imageVector = Icons.Default.Refresh, contentDescription = "",
                    modifier = Modifier
                        .size(48.dp)
                        .rotate(state.value.toFloat())
                )
                Text(text = "Loading")
            }
        }
    }

    @Composable
    private fun DerivedStateSideEffect() {

        val state1 = remember { mutableStateOf(5) }
        val state2 = produceState(initialValue = 1) {
            repeat(9){
                delay(1500)
                value++
            }
        }
        /*val state22 = remember { mutableStateOf(1) }*/

        val finalState = remember {
            derivedStateOf {  "${state1.value} * ${state2.value} = ${state1.value*state2.value}" }
        }
        Text(text = "Table of ${state1.value}")
        Text(text = finalState.value)
    }


    @Preview(showSystemUi = true, showBackground = true)
    @Composable
    private fun previewCompose() {
        WithSideEffect()
    }

    override fun onRestart() {
        super.onRestart()
    }
}