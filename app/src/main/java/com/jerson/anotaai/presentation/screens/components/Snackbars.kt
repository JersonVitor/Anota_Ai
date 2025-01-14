package com.jerson.anotaai.presentation.screens.components

import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

enum class StringSnackbar(val message :String){
    Error("Título e/ou Conteúdo vazios!!"),
    Delete("Deseja apagar essa nota?")
}

@Composable
fun SnackbarView(
    modifier: Modifier = Modifier,
    snackbarHostState: SnackbarHostState,
    ) {
    SnackbarHost(
        hostState = snackbarHostState,
        snackbar = { data ->
           when(data.visuals.message){
              StringSnackbar.Error.message ->{
                  Snackbar(
                      contentColor = Color.White,  // Cor do texto
                      containerColor = Color.Red,  // Cor de fundo do Snackbar
                      snackbarData =  data
                  )
              }
               StringSnackbar.Delete.message ->{
                   Snackbar(
                       snackbarData = data
                   )
               }
           }


        }
    )
}