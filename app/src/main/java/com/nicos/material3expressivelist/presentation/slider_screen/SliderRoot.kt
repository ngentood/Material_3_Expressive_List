package com.nicos.material3expressivelist.presentation.slider_screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.nicos.material3expressivelist.presentation.CustomToolbar
import com.nicos.material3expressivelist.presentation.navigation.navigation_3.Navigator

@Composable
fun SliderRoot(
    navigator: Navigator
) {
    Scaffold(
        topBar = {
            CustomToolbar(
                title = "Slider",
                backButton = {
                    navigator.goBack()
                }
            )
        }
    ) { paddingValues ->
        SliderScreen(paddingValues = paddingValues)
    }
}

@Composable
private fun SliderScreen(
    paddingValues: PaddingValues
) {

}