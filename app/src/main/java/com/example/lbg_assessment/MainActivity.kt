package com.example.lbg_assessment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.lbg_assessment.presentation.navigation.AppNavHost
import com.example.lbg_assessment.presentation.ui.theme.LBG_AssessmentTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LBG_AssessmentTheme {
                AppNavHost()
            }
        }
    }
}
