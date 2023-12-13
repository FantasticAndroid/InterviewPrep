package com.offline.first.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.offline.first.R
import com.offline.first.ui.theme.OfflineFirstDemoTheme

class ComposeDemoActivity : ComponentActivity() {
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

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun previewCompose() {

    LazyColumn(
        content = {
            items(getCategoryList()) {
                CardHolder(category = it)
            }
        }
    )

    /*Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        getCategoryList().forEach {
            CardHolder(it)
        }
    }*/
}

@Composable
private fun CardHolder(category: Category) {
    Card(
        //elevation = CardElevation()
        modifier = Modifier.padding(4.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(6.dp)
        ) {
            Image(
                painter = painterResource(id = category.resId), contentDescription = "Image Item",
                modifier = Modifier.weight(.2f)
            )
            Column(
                modifier = Modifier
                    .padding(4.dp)
                    .weight(0.8f)
            ) {
                Text(
                    text = category.title,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = category.subTitle,
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Thin
                )

            }
        }
    }
}

data class Category(@DrawableRes val resId: Int, val title: String, val subTitle: String)


fun getCategoryList(): ArrayList<Category> {

    return ArrayList<Category>().apply {
        add(Category(R.drawable.android_cupcake, "Title1", "SubTitle1"))
        add(Category(R.drawable.android_cupcake, "Title2", "SubTitle2"))
        add(Category(R.drawable.android_cupcake, "Title3", "SubTitle3"))
        add(Category(R.drawable.android_cupcake, "Title4", "SubTitle4"))
        add(Category(R.drawable.android_cupcake, "Title5", "SubTitle5"))
        add(Category(R.drawable.android_cupcake, "Title6", "SubTitle6"))
        add(Category(R.drawable.android_cupcake, "Title7", "SubTitle1"))
        add(Category(R.drawable.android_cupcake, "Title8", "SubTitle2"))
        add(Category(R.drawable.android_cupcake, "Title9", "SubTitle3"))
        add(Category(R.drawable.android_cupcake, "Title10", "SubTitle4"))
        add(Category(R.drawable.android_cupcake, "Title11", "SubTitle5"))
        add(Category(R.drawable.android_cupcake, "Title12", "SubTitle6"))
        add(Category(R.drawable.android_cupcake, "Title13", "SubTitle1"))
        add(Category(R.drawable.android_cupcake, "Title14", "SubTitle2"))
        add(Category(R.drawable.android_cupcake, "Title15", "SubTitle3"))
        add(Category(R.drawable.android_cupcake, "Title16", "SubTitle4"))
        add(Category(R.drawable.android_cupcake, "Title17", "SubTitle5"))
        add(Category(R.drawable.android_cupcake, "Title18", "SubTitle6"))
    }
}