package com.jerson.anotaai.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.jerson.anotaai.presentation.navgraph.NavGraph
import com.jerson.anotaai.ui.theme.AnotaAiTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AnotaAiTheme {
                val navController = rememberNavController()
                NavGraph(navController)
            }
        }
    }
}
