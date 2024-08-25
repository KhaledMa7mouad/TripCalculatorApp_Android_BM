package com.example.trip_calculator_internship_android
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun OptionsScreen(
    navController: NavController,
    km: Float,
    time: Int,
    modifier: Modifier = Modifier
) {
    var selected by remember { mutableStateOf("") }
    val state = remember { SnackbarHostState() }
    val context = LocalContext.current

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = state)
        }
    ) { padding ->
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            selected = getSelectedRadioButton(modifier)
            Button(
                onClick = {
                    val traffic = when (selected) {
                        "Feeling Lucky (+0%)" -> 0.0
                        "Safe Zone (+5%)" -> 0.05
                        else -> 0.10
                    }
                    // Perform action with the traffic value
                },
                modifier = modifier.padding(top = 32.dp)
            ) {
                Text(text = stringResource(R.string.calculate_trip_price))
            }
        }
    }

    LaunchedEffect(Unit) {
        val result = state.showSnackbar(
            message = context.getString(R.string.price_calculated_successfully),
            actionLabel = context.getString(R.string.start_over),
            duration = SnackbarDuration.Indefinite
        )
        if (result == SnackbarResult.ActionPerformed) {
            navController.popBackStack(Routes.START, false)
        }
    }
}


@Composable
fun getSelectedRadioButton(modifier: Modifier = Modifier): String {
    var selectedRadioButton by remember { mutableStateOf("Feeling Lucky (+0%)") }

    val trafficOptions =
        arrayOf("Feeling Lucky (+0%)", "Safe Zone (+5%)", "Heavy Traffic (+10%)")

    trafficOptions.forEach { item ->
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.selectable(
                selected = selectedRadioButton == item,
                onClick = { selectedRadioButton = item }
            )
        ) {
            RadioButton(
                selected = selectedRadioButton == item,
                onClick = {
                    selectedRadioButton = item
                })
            Text(
                text = item,
                style = MaterialTheme.typography.bodyLarge,
            )
        }
    }
    return selectedRadioButton
}

@Preview(showBackground = true)
@Composable
fun OptionsScreenPreview() {
    OptionsScreen(rememberNavController(), 20.5f, 12)
}