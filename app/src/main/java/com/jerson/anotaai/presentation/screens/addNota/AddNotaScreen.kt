package com.jerson.anotaai.presentation.screens.addNota

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jerson.anotaai.domain.model.Nota
import com.jerson.anotaai.presentation.screens.components.PalletColors
import com.jerson.anotaai.presentation.screens.components.TextFieldNota


import com.jerson.anotaai.ui.theme.AnotaAiTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNotaScreen(
    modifier: Modifier = Modifier,
    onSave: () -> Unit,
    onBack: () -> Unit,
    state: AddNotaState,
    event: (AddNotaEvent) -> Unit
) {
    val coroutineScope = rememberCoroutineScope()
    val snackBarHostState = remember{ SnackbarHostState()}
    val keyboardController = LocalSoftwareKeyboardController.current
    Scaffold(
        snackbarHost = {
            SnackbarHost(
                hostState = snackBarHostState,
                snackbar = {
                    Snackbar(
                        contentColor = Color.White,  // Cor do texto
                        containerColor = Color.Red,  // Cor de fundo do Snackbar
                        snackbarData =  it
                    )
                }
            ) },
        modifier = modifier,
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Criar Nota",
                        style = MaterialTheme.typography.titleMedium
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        keyboardController?.hide()
                        onBack()
                    }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Voltar"
                        )
                    }
                },
                actions = {
                    PalletColors(
                        onClick = {
                            event(AddNotaEvent.UpdateColor(it))
                        }
                    )
                    IconButton(
                        onClick = {
                            if (isValid(state.nota)) {
                                keyboardController?.hide()
                                event(AddNotaEvent.InsertNota)
                                onSave()
                            }else {
                                coroutineScope.launch {
                                    snackBarHostState.showSnackbar(message = "Título e/ou Conteúdo vazios!!")
                                }
                            }
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Done,
                            contentDescription = "Salvar"
                        )
                    }
                }
            )
        },
    ) { it ->
        val up = it.calculateTopPadding()
        Column(
            modifier = Modifier
                .padding(top = up)
                .padding(horizontal = 10.dp)
        ) {

            TextFieldNota(
                placeholder = "Sem Título",
                text = state.nota.titulo,
                onChangeValue = {
                    event(AddNotaEvent.AtualizarTitulo(titulo = it))
                },
                textStyle = MaterialTheme.typography.titleLarge
            )
            TextFieldNota(
                placeholder = "Comece a escrever...",
                text = state.nota.conteudo,
                onChangeValue = {
                    event(AddNotaEvent.AtualizarTexto(conteudo = it))
                },
                textStyle = MaterialTheme.typography.bodyMedium,
               // modifier = Modifier.fillMaxSize()
            )
        }
    }
}

fun isValid(nota: Nota): Boolean {
    return !(nota.titulo.isEmpty() || nota.conteudo.isEmpty())
}
@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun AddNotaScreenPrev() {
    AnotaAiTheme {
        AddNotaScreen(onBack = {}, onSave = {}, state = AddNotaState(), event = {})
    }
}