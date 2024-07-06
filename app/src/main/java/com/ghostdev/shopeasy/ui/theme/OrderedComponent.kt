package com.ghostdev.shopeasy.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.ghostdev.shopeasy.R

@Composable
fun OrderCompleteComponent() {
    Column(modifier = Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            painter = painterResource(id = R.drawable.baseline_check_circle_24), contentDescription = "ordered")

        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = "Order Successful")
    }
}