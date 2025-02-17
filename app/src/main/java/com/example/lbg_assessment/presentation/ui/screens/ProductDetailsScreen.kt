package com.example.lbg_assessment.presentation.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.lbg_assessment.utils.Constant.EMPTY_STRING

@Composable
fun ProductDetailsScreen(
    productTitle: String
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Details Screen for \n$productTitle",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            style = typography.bodyLarge
        )
    }
}

@Preview
@Composable
private fun ProductDetailsScreenPreview(){
    ProductDetailsScreen(productTitle = EMPTY_STRING)
}