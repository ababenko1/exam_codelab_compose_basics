package com.example.examcodelabcomposebasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.examcodelabcomposebasics.ui.compose.GreetingScreen
import com.example.examcodelabcomposebasics.ui.theme.ExamCodelabComposeBasicsTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExamCodelabComposeBasicsTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier) {
    var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }
    Surface(modifier = modifier) {
        if (shouldShowOnboarding) {
            OnboardingScreen(shouldShowOnboarding = { shouldShowOnboarding = !shouldShowOnboarding })
        } else {
            GreetingScreen()
        }
    }
}

