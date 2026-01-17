@file:OptIn(ExperimentalMaterial3Api::class)

package com.nicos.material3expressivelist.presentation.slider_screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.nicos.material3expressivelist.BuildConfig
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

@Composable
private fun StandardSliderExample() {
    var sliderPosition by remember { mutableFloatStateOf(0F) }

    Text("Slider")
    Slider(
        value = sliderPosition,
        onValueChange = {
            sliderPosition = it
            if (BuildConfig.DEBUG) {
                Log.d("StandardSlider", "Slider value at: ${sliderPosition.toInt()}")
            }
        },
        colors = SliderDefaults.colors(
            thumbColor = MaterialTheme.colorScheme.secondary,
            activeTrackColor = MaterialTheme.colorScheme.secondary,
            inactiveTrackColor = MaterialTheme.colorScheme.secondaryContainer,
        ),
        steps = 9,
        valueRange = 0f..100f,
        onValueChangeFinished = {
            if (BuildConfig.DEBUG) {
                Log.d("StandardSlider", "Slider value finished at: ${sliderPosition.toInt()}")
            }
        },
        track = { sliderPositions ->
            SliderDefaults.Track(
                trackInsideCornerSize = 5.dp,
                thumbTrackGapSize = 3.dp,
                sliderState = sliderPositions,
                modifier = Modifier
                    .fillMaxWidth(),
            )
        },
        thumb = {
            CustomThumb(value = sliderPosition.toInt())
        }
    )
}

@Composable
private fun CustomThumb(
    value: Int,
    color: Color = MaterialTheme.colorScheme.secondary
) {
    Box(
        Modifier
            .size(size = 30.dp)
            .shadow(
                elevation = 10.dp,
                shape = CircleShape,
            )
            .background(
                color = color,
                shape = CircleShape
            ),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = value.toString(),
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}