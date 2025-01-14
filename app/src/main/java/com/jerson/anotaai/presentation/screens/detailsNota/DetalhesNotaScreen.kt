package com.jerson.anotaai.presentation.screens.detailsNota

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import com.jerson.anotaai.domain.model.Nota
import com.jerson.anotaai.presentation.screens.components.PalletColors
import com.jerson.anotaai.presentation.screens.components.SnackbarView
import com.jerson.anotaai.presentation.screens.components.StringSnackbar
import com.jerson.anotaai.presentation.screens.components.TextFieldNota
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetalhesNotaScreen(
    modifier: Modifier = Modifier,
    onBack: () -> Unit,
    state: DetalhesNotaState,
    event: (DetalhesNotaEvent) -> Unit
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember{ SnackbarHostState()}
    Scaffold(
        snackbarHost = {
            SnackbarView(snackbarHostState = snackbarHostState)
        },
        modifier = modifier,
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        if(state.edit)"Edição de nota" else "Detalhes da Nota" ,
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
                    if (state.edit)
                        PalletColors(
                        onClick = {
                            event(DetalhesNotaEvent.UpdateColor(it))
                        }
                    )else{
                        IconButton(onClick = {
                            coroutineScope.launch {
                                snackDelete(snackbarHostState, event, onBack)
                            }

                        }) {
                            Icon(imageVector = Icons.Filled.Delete, contentDescription = "Apagar nota")
                        }
                    }

                    IconButton(
                        onClick = {
                            if(state.edit){
                                if (isValid(state.nota)) {
                                    event(DetalhesNotaEvent.UpdateNota)
                                }else{
                                    coroutineScope.launch {
                                        snackbarHostState.showSnackbar(message = StringSnackbar.Error.message)
                                    }
                                }

                            }
                            event(DetalhesNotaEvent.ModoEdicao)
                        }
                    ) {
                      if (state.edit){
                          Icon(
                              imageVector = Icons.Filled.Done,
                              contentDescription = "Salvar nota"
                          )
                      }else{
                          Icon(
                              imageVector = Icons.Outlined.Edit,
                              contentDescription = "Editar nota"
                          )
                      }
                    }
                }


            )
        }
    ) { it ->
        val up = it.calculateTopPadding()
        Column(
            modifier = Modifier
                .padding(top = up)
                .padding(horizontal = 10.dp).fillMaxSize()
        ) {

            TextFieldNota(
                text = state.nota.titulo,
                onChangeValue = {
                    event(DetalhesNotaEvent.AtualizarTitulo(titulo = it))
                },
                textStyle = MaterialTheme.typography.titleLarge,
                enable = state.edit,
                placeholder = "Sem Título"
            )
            TextFieldNota(
                modifier = Modifier.fillMaxSize(),
                text = state.nota.conteudo,
                onChangeValue = {
                    event(DetalhesNotaEvent.AtualizarTexto(conteudo = it))
                },
                textStyle = MaterialTheme.typography.bodyMedium,
                enable = state.edit,
                placeholder = "Sem Título"
            )


        }
    }
}


private suspend fun snackDelete(
    snackbarHostState: SnackbarHostState,
    event: (DetalhesNotaEvent) -> Unit,
    onBack: () -> Unit
) {
    val result = snackbarHostState
        .showSnackbar(
            message = StringSnackbar.Delete.message,
            actionLabel = "Sim",
            withDismissAction = true,
            duration = SnackbarDuration.Indefinite
        )
    when (result) {
        SnackbarResult.ActionPerformed -> {
            event(DetalhesNotaEvent.DeleteNota)
            onBack()
        }

        SnackbarResult.Dismissed ->{}
    }
}

fun isValid(nota: Nota): Boolean {
    return !(nota.titulo.isEmpty() || nota.conteudo.isEmpty())
}