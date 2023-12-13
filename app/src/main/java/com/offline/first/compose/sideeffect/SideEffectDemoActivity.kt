package com.offline.first.compose.sideeffect

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.offline.first.ui.theme.OfflineFirstDemoTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * https://developer.android.com/jetpack/compose/side-effects
 * https://medium.com/@mortitech/exploring-side-effects-in-compose-f2e8a8da946b
 *
 * Two ways to Run Side Effects
 * 1. LaunchEffect
 * 2. rememberCoroutineScope
 */
private const val TAG = "SideEffectDemoActivity"
class SideEffectDemoActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WithSideEffect()
        }
    }

    @Composable
    private fun WithSideEffect(){
        OfflineFirstDemoTheme() {
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                //SideEffect2()
                //CoroutineScopeSideEffect3()
                UpdateRememberState()
            }
        }
    }

    @Composable
    private fun SideEffect1() {
        val countState = remember {
            mutableStateOf(0)
        }
        // SideEffect
        Log.d(TAG, "countStateSideEffect: ${countState.value}")

        // or WithoutSideEffect
        LaunchedEffect(key1 = Unit) {
            Log.d(TAG, "countStateNoSideEffect: ${countState.value}")
        }

        // conditionally launch
        val key = countState.value%3 == 0
        LaunchedEffect(key1 = key) {
            Log.d(
                TAG,
                "countStateNoSideEffect: key: $key, ${countState.value}"
            )
        }

        Button(onClick = { countState.value++ }) {
            Text(text = "Count: ${countState.value}")
        }
    }

    @Composable
    private fun SideEffect2() {
        val countState = remember {
            mutableStateOf(0)
        }
        // conditionally launch
        LaunchedEffect(key1 = Unit) {
            Log.d(TAG, "LaunchedEffect: count: ${countState.value}")
            try {
                (1..100).forEach {
                    delay(2000L)
                    countState.value++
                }
            } catch (e: Exception) {
                // Not Working in new Compose
                Log.e(TAG, "EXception: ${e.message}")
            }
        }
        val text = if(countState.value == 100){
            "Counter Stopped: ${countState.value}"
        }else{
            "Counter Running: ${countState.value}"
        }

        Button(onClick = { countState.value++ }) {
            Text(text = text)
        }
    }

    @Composable
    private fun CoroutineScopeSideEffect3() {
        val countState = remember {
            mutableStateOf(0)
        }
        val cScope = rememberCoroutineScope()

        // conditionally launch
        val text = if(countState.value == 100){
            "Counter Stopped: ${countState.value}"
        }else{
            "Counter Running: ${countState.value}"
        }

        Button(onClick = {
            cScope.launch {
                countState.value = 0
                Log.d(TAG, "CoroutineScope: count: ${countState.value}")
                try {
                    (1..100).forEach {
                        delay(2000L)
                        countState.value++
                    }
                } catch (e: Exception) {
                    // Not Working in new Compose
                    Log.e(TAG, "EXception: ${e.message}")
                }
            }
        }) {
            Text(text = text)
        }
    }

    @Composable
    private fun SideEffect() {

        val listState = remember {
            mutableStateOf(emptyList<String>())
        }
        // This is Side effect, because Compose this API call multiple times
        // For Ex: Show Snackbar UI should only call once, but in compose it can be called multiple times
        // due to compose function behavior
        listState.value = fetchList()

        // To handle Side Effect. One the basis of key, code will be executed.
        // LaunchedEffect is used for one time activity.
        LaunchedEffect(key1 = Unit) {
            listState.value = fetchListAPI()
        }

        LazyColumn {
            items(listState.value) {
                Text(text = it)
            }
        }
    }

    /**
     * Mimic of API call
     * @return ArrayList<String>
     */
    private fun fetchList() = arrayListOf("Ram", "Shyam", "Geeta")

    private suspend fun fetchListAPI() = arrayListOf("RamS", "ShyamS", "GeetaS")

    private fun state1() = Log.d(TAG, "STATE1")
    private fun state2() = Log.d(TAG, "STATE2")

    @Composable
    fun UpdateRememberState(){
        val state = remember {
            mutableStateOf(::state1)
        }
        Button(onClick = { state.value = ::state2 }) {
            Text(text = "Change State")
        }

        BackgroundOpt(state.value)
    }

    private @Composable
    fun BackgroundOpt(stateFunction: () -> Int) {
        val rState = rememberUpdatedState(newValue = stateFunction)
        LaunchedEffect(key1 = Unit) {
            delay(5000)
            rState.value.invoke()
        }
    }

    @Preview(showSystemUi = true, showBackground = true)
    @Composable
    private fun previewCompose() {
        WithSideEffect()
    }
}