package com.example.examcodelabcomposebasics

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.examcodelabcomposebasics.ui.theme.ExamCodelabComposeBasicsTheme
import com.example.examcodelabcomposebasics.ui.theme.PaddingMedium

@Composable
fun OnboardingScreen(
    shouldShowOnboarding: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                stringResource(R.string.welcome_to_basics_codelab),
                modifier = Modifier.padding(vertical = PaddingMedium)
            )
            Button(onClick = shouldShowOnboarding) {
                Text(text = stringResource(id = R.string.continue_button))
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnboardingScreenPreview() {
    ExamCodelabComposeBasicsTheme {
        OnboardingScreen(shouldShowOnboarding = {})
    }
}