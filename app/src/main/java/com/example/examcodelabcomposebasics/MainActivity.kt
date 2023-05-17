package com.example.examcodelabcomposebasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.examcodelabcomposebasics.ui.theme.*


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExamCodelabComposeBasicsTheme {
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun MyApp(
    modifier: Modifier = Modifier,
    names: List<String> = listOf("Android", "Compose"),
) {
    Column(
        modifier = modifier.padding(PaddingSmall)
    ) {
        for (name in names) {
            Greeting(name)
        }
    }
}

@Composable
fun Greeting(name: String) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    val extraPadding = if (expanded) PaddingExtra else PaddingNone
    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(PaddingSmall)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(PaddingMedium)
        ) {

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding)
            ) {
                Text(text = "Hello, ")
                Text(text = "$name!")
            }

            OutlinedButton(onClick = { expanded = !expanded }) {
                Text(
                    if (expanded) stringResource(id = R.string.show_less)
                    else stringResource(id = R.string.show_more)
                )
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview() {
    ExamCodelabComposeBasicsTheme {
        MyApp()
    }
}