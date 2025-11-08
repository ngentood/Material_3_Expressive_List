@file:OptIn(ExperimentalMaterial3ExpressiveApi::class)

package com.nicos.material3expressivelist.presentation.loading_progress_indicator

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animate
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularWavyProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.LinearWavyProgressIndicator
import androidx.compose.material3.LoadingIndicator
import androidx.compose.material3.LoadingIndicatorDefaults
import androidx.compose.material3.MaterialShapes
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.graphics.shapes.RoundedPolygon
import androidx.navigation.NavController
import com.nicos.material3expressivelist.presentation.CustomToolbar
import kotlin.ranges.rangeTo

@Composable
fun LoadingProgressIndicatorRoot(
    navController: NavController,
) {
    Scaffold(
        topBar = {
            CustomToolbar(
                title = "Loading/Progress Indicator",
                backButton = {
                    navController.popBackStack()
                }
            )
        }
    ) { paddingValues ->
        Column(
            Modifier.verticalScroll(
                state = rememberScrollState(),
            ),
        ) {
            LoadingIndicatorScreen(
                paddingValues = paddingValues
            )
            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 30.dp),
                thickness = 3.dp,
                color = MaterialTheme.colorScheme.outline
            )
            LoadingIndicatorInfinity(
                paddingValues = paddingValues,
                title = "Loading Infinity (Default)"
            )
            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 30.dp),
                thickness = 3.dp,
                color = MaterialTheme.colorScheme.outline
            )
            LoadingIndicatorInfinity(
                paddingValues = paddingValues,
                polygons = LoadingIndicatorDefaults.IndeterminateIndicatorPolygons,
                title = "Loading Infinity (IndeterminateIndicatorPolygons)"
            )
            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 30.dp),
                thickness = 3.dp,
                color = MaterialTheme.colorScheme.outline
            )
            LoadingIndicatorInfinity(
                paddingValues = paddingValues,
                polygons = listOf(
                    MaterialShapes.Fan,
                    MaterialShapes.Boom,
                    MaterialShapes.Arrow,
                    MaterialShapes.ClamShell,
                    MaterialShapes.Circle,
                    MaterialShapes.Oval,
                    MaterialShapes.Flower,
                    MaterialShapes.Triangle
                ),
                title = "Loading Infinity (Custom)"
            )
            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 30.dp),
                thickness = 3.dp,
                color = MaterialTheme.colorScheme.outline
            )
            LoadingLinearIndicatorInfinity(
                paddingValues = paddingValues
            )
            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 30.dp),
                thickness = 3.dp,
                color = MaterialTheme.colorScheme.outline
            )
            LoadingLinearWaveIndicatorInfinity(
                paddingValues = paddingValues
            )
            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 30.dp),
                thickness = 3.dp,
                color = MaterialTheme.colorScheme.outline
            )
            LoadingLCircularIndicatorInfinity(
                paddingValues = paddingValues
            )
            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 30.dp),
                thickness = 3.dp,
                color = MaterialTheme.colorScheme.outline
            )
        }
    }
}

@Composable
fun LoadingIndicatorScreen(
    paddingValues: PaddingValues,
    polygons: List<RoundedPolygon> = LoadingIndicatorDefaults.DeterminateIndicatorPolygons,
) {
    var progress by remember { mutableFloatStateOf(0f) }
    val animatedProgress by
    animateFloatAsState(
        targetValue = progress,
        animationSpec =
            spring(
                dampingRatio = Spring.DampingRatioNoBouncy,
                stiffness = Spring.StiffnessVeryLow,
                visibilityThreshold = 1 / 1000f,
            ),
    )

    Column(
        Modifier.padding(
            top = paddingValues.calculateTopPadding(),
        ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LoadingIndicator(
            progress = { animatedProgress },
            polygons = polygons
        )
        Spacer(Modifier.requiredHeight(30.dp))
        Text("Set loading progress:")
        Slider(
            modifier = Modifier
                .width(500.dp)
                .padding(
                    horizontal = 50.dp
                ),
            value = progress,
            valueRange = 0f..1f,
            onValueChange = { progress = it },
        )
    }
}

@Composable
fun LoadingIndicatorInfinity(
    paddingValues: PaddingValues,
    polygons: List<RoundedPolygon> = LoadingIndicatorDefaults.DeterminateIndicatorPolygons,
    title: String = ""
) {
    var progress by remember { mutableFloatStateOf(0f) }

    // Use LaunchedEffect to automatically animate the progress over time.
    LaunchedEffect(Unit) {
        // This will loop indefinitely.
        while (true) {
            // Animate from 0f to 1f over 5000 milliseconds (5 seconds).
            animate(
                initialValue = 0f,
                targetValue = 1f,
                animationSpec = tween(durationMillis = 5000)
            ) { value, _ ->
                progress = value
            }
        }
    }

    Column(
        Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = title)
        Spacer(Modifier.requiredHeight(30.dp))
        LoadingIndicator(
            progress = { progress },
            polygons = polygons
        )
    }
}

@Composable
fun LoadingLinearIndicatorInfinity(
    paddingValues: PaddingValues,
) {
    var progress by remember { mutableFloatStateOf(0f) }

    // Use LaunchedEffect to automatically animate the progress over time.
    LaunchedEffect(Unit) {
        // This will loop indefinitely.
        while (true) {
            // Animate from 0f to 1f over 5000 milliseconds (5 seconds).
            animate(
                initialValue = 0f,
                targetValue = 1f,
                animationSpec = tween(durationMillis = 5000)
            ) { value, _ ->
                progress = value
            }
        }
    }

    Column(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Linear Progress Indicator")
        Spacer(Modifier.requiredHeight(30.dp))
        LinearProgressIndicator(
            progress = { progress },
            modifier = Modifier.fillMaxWidth(),
        )
    }
}

@Composable
fun LoadingLinearWaveIndicatorInfinity(
    paddingValues: PaddingValues,
) {
    var progress by remember { mutableFloatStateOf(0f) }

    // Use LaunchedEffect to automatically animate the progress over time.
    LaunchedEffect(Unit) {
        // This will loop indefinitely.
        while (true) {
            // Animate from 0f to 1f over 5000 milliseconds (5 seconds).
            animate(
                initialValue = 0f,
                targetValue = 1f,
                animationSpec = tween(durationMillis = 5000)
            ) { value, _ ->
                progress = value
            }
        }
    }

    Column(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Linear Wavy Progress Indicator")
        Spacer(Modifier.requiredHeight(30.dp))
        LinearWavyProgressIndicator(
            progress = { progress },
            modifier = Modifier.fillMaxWidth(),
        )
    }
}

@Composable
fun LoadingLCircularIndicatorInfinity(
    paddingValues: PaddingValues,
) {
    var progress by remember { mutableFloatStateOf(0f) }

    // Use LaunchedEffect to automatically animate the progress over time.
    LaunchedEffect(Unit) {
        // This will loop indefinitely.
        while (true) {
            // Animate from 0f to 1f over 5000 milliseconds (5 seconds).
            animate(
                initialValue = 0f,
                targetValue = 1f,
                animationSpec = tween(durationMillis = 5000)
            ) { value, _ ->
                progress = value
            }
        }
    }

    Column(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Circular Wavy Progress Indicator")
        Spacer(Modifier.requiredHeight(30.dp))
        CircularWavyProgressIndicator(
            progress = { progress },
            modifier = Modifier.size(50.dp),
        )
    }
}