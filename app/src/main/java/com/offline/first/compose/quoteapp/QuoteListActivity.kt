package com.offline.first.compose.quoteapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.ThumbUp
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.offline.first.R
import com.offline.first.compose.quoteapp.model.Quote
import com.offline.first.ui.theme.OfflineFirstDemoTheme

class QuoteListActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OfflineFirstDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Quotes()
                }
            }
        }
    }
}

@Composable
private fun Quotes() {
    Column {
        val context = LocalContext.current
        Text(text = context.getString(R.string.app_name),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(1f))
    }
}

@Composable
fun QuoteList() {
    val context = LocalContext.current
    val quoteList = remember {
        mutableStateOf(DataManager.loadAppQuotes(context))
    }

    LazyColumn(content = {
        items(quoteList.value) { quote ->
            QuoteListItem(quote){
                Toast.makeText(context, quote.content, Toast.LENGTH_SHORT).show()
            }
        }
    })
}

@Composable
fun QuoteListItem(quote: Quote, onQuoteClick: ((quote: Quote) -> Unit)?) {
    Card(
        modifier = Modifier
            .padding(6.dp)
            .clickable {
                onQuoteClick?.invoke(quote)
            }
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
        ) {
            Image(
                imageVector = Icons.Sharp.ThumbUp,
                colorFilter = ColorFilter.tint(Color.White),
                modifier = Modifier
                    .size(32.dp)
                    .rotate(180f)
                    .background(Color.Black)
                    .padding(4.dp),
                contentDescription = "Quote"
            )
            Spacer(modifier = Modifier.padding(4.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = quote.content ?: "",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Box(
                    modifier = Modifier
                        .background(Color(0x55555555))
                        .height(1.dp)
                        .fillMaxWidth(0.4f)
                )
                Text(
                    text = quote.author ?: "",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Thin
                )
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun PreviewQuotes() {
    Quotes()
}