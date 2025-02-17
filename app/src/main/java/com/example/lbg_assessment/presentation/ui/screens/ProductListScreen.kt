package com.example.lbg_assessment.presentation.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lbg_assessment.presentation.navigation.NavigationLBG
import com.example.lbg_assessment.presentation.ui.screens.components.ListItem
import com.example.lbg_assessment.presentation.ui.state.ProductListState
import com.example.lbg_assessment.presentation.ui.theme.LBG_AssessmentTheme
import com.example.lbg_assessment.utils.Constant.TITLE_STRING


@Composable
fun ProductListScreen(result: ProductListState,
                      onClick:(String) -> Unit) {

    if(result.isLoading){
        Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            CircularProgressIndicator(modifier = Modifier.size(50.dp))
        }

    }

    result.data?.let {
        Column(modifier = Modifier.fillMaxSize().padding(top = 50.dp)) {
            LazyColumn {
                items(it){ item->
                    ListItem(item){ product->
                        onClick(NavigationLBG.ProductDetailsScreen.route + "/{$TITLE_STRING}"
                            .replace("{$TITLE_STRING}", newValue = product.title))
                    }
                }
            }
        }
    }

    if(result.error.isNotEmpty()){
        Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Text(text = result.error.toString())
        }
    }
}

@Preview
@Composable
private fun ProductListScreenPreview() {
    LBG_AssessmentTheme {
        ProductListScreen(
            result = ProductListState(isLoading = true),
            onClick = {}
        )
    }

}