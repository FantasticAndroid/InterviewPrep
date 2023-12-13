package com.offline.first.compose.sideeffect

import android.os.Bundle
import android.util.Log
import android.view.ViewTreeObserver
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.offline.first.ui.theme.OfflineFirstDemoTheme

private const val TAG = "SideEffectWithCleanUpDemoActivity"
class SideEffectWithCleanUpDemoActivity : ComponentActivity() {

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
                DisposeSideEffect2()
            }
        }
    }

    @Composable
    private fun DisposeSideEffect() {

        val state = remember { mutableStateOf(false) }
        DisposableEffect(key1 = Unit) {
            Log.d(TAG, "DisposableEffect Stared")
            onDispose {
                Log.d(TAG, "DisposableEffect disposed")
            }
        }
        Button(onClick = { state.value = !state.value }) {
            Text(text = "ChangeState: ${state.value}")
        }
    }

    @Composable
    private fun DisposeSideEffect2() {
        TextField(value = "", onValueChange = {})
        val view = LocalView.current
        DisposableEffect(key1 = Unit) {

            val listener = ViewTreeObserver.OnGlobalLayoutListener {
                val isKeyboardVisible =
                    ViewCompat.getRootWindowInsets(view)?.isVisible(WindowInsetsCompat.Type.ime())
                Log.d(TAG, "isKeyboardVisible: $isKeyboardVisible")
            }

            view.viewTreeObserver.addOnGlobalLayoutListener(listener)
            onDispose {
                view.viewTreeObserver.removeOnGlobalLayoutListener(listener)
            }
        }
    }

    @Preview(showSystemUi = true, showBackground = true)
    @Composable
    private fun previewCompose() {
        WithSideEffect()
    }
}