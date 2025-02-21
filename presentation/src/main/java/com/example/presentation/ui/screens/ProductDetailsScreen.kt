package com.example.presentation.ui.screens

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.getString
import com.example.domain.utils.Constant.EMPTY_STRING
import com.example.presentation.R

@Composable
fun ProductDetailsScreen(
    context: Context,
    productTitle: String
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = String.format(getString(context, R.string.details_placeholder), productTitle),
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            style = typography.bodyLarge
        )
    }
}

@Preview
@Composable
private fun ProductDetailsScreenPreview(){
    ProductDetailsScreen(
        context = LocalContext.current,
        productTitle = EMPTY_STRING
    )
}