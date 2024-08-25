package com.example.trip_calculator_internship_android

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun TimeScreen(navController: NavController, distance: Float, modifier: Modifier = Modifier) {

    var timeField by remember { mutableStateOf("") }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Text(text = stringResource(id = R.string.enter_the_total_time))

        OutlinedTextField(
            value = timeField,
            onValueChange = { it ->
                timeField = it.filter {
                    it.isDigit()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 32.dp),
            label = {
                Text(text = stringResource(id = R.string.distance_in_kilometers))
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Button(
            onClick = {
                navController.navigate("${Routes.OPTIONS}/${distance}/${timeField.toInt()}")
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text(text = stringResource(id = R.string.next))
        }

    }
}

@Preview
@Composable
private fun TimeScreenPreview() {
    TimeScreen(rememberNavController(), 15.4f)
}