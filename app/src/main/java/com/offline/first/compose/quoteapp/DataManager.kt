package com.offline.first.compose.quoteapp

import android.content.Context
import android.util.Log
import com.google.gson.GsonBuilder
import com.offline.first.compose.quoteapp.model.Quote
import com.offline.first.compose.quoteapp.model.QuoteResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async

private const val TAG = "DataManager"
object DataManager {

    suspend fun loadQuotes(context: Context): ArrayList<Quote> {
        Log.d(TAG, "loadQuotes")
        return CoroutineScope(Dispatchers.IO).async {
            loadAppQuotes(context)
        }.await()
    }

    fun loadAppQuotes(context: Context): ArrayList<Quote> {
        Log.d(TAG, "loadAppQuotes")
        return context.assets.open("quotes.txt").let { stream ->
            val bArray = ByteArray(size = stream.available())
            stream.read(bArray)
            stream.close()
            val jString = String(bArray, Charsets.UTF_8)
            GsonBuilder().create().fromJson(jString, QuoteResponse::class.java).results
        }
    }
}