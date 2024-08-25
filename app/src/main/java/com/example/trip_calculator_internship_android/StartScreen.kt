package com.example.trip_calculator_internship_android

import android.media.MediaPlayer
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun StartScreen( navController: NavController,modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxSize()
    ) {
       Image(
           painter = painterResource(id = R.drawable.road),
           contentDescription = stringResource(id = R.string.road),
           modifier = modifier
               .size(300.dp)

       )

        Button(
            onClick = {
                navController.navigate(Routes.DESTINATION)
            },
            modifier = modifier
                .align(Alignment.CenterHorizontally),


        ) {
         Text(
             text = stringResource(id = R.string.start)
         )
        }
        Image(
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 160.dp)

                .size(300.dp),
            painter = painterResource(id = R.drawable.car),
            contentDescription = stringResource(id = R.string.car)


        )




    }
}


@Preview(showSystemUi = true)
@Composable
 fun StartScreenPreview () {

}


