package com.jerson.anotaai.presentation.screens.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.jerson.anotaai.R
import com.jerson.anotaai.domain.model.Nota
import com.jerson.anotaai.presentation.screens.components.BtnAddNota
import com.jerson.anotaai.presentation.screens.components.DropdownMenuHome
import com.jerson.anotaai.presentation.screens.components.NotasGrid
import com.jerson.anotaai.presentation.screens.components.NotasList
import com.jerson.anotaai.ui.theme.ColorBtnAddNota

import kotlinx.coroutines.flow.Flow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onNavigateDetails: (Nota) -> Unit,
    onNavigateAddNota: () -> Unit,
    state: HomeState,
    notas: Flow<List<Nota>>,
    event: (HomeEvent) -> Unit
) {

    var layoutGrid by remember { mutableStateOf(false) }
    var habiliteDelete by remember  { mutableStateOf(false)}




    Scaffold(
        modifier = Modifier,
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Anota Uai",
                        style = MaterialTheme.typography.titleMedium
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        layoutGrid = !layoutGrid
                    }) {
                       if (layoutGrid){
                           Icon(imageVector = Icons.AutoMirrored.Filled.List, contentDescription = "Organização em Lista")
                       }else{
                           Icon(painter = painterResource(R.drawable.baseline_grid_view_24), contentDescription = "Organização em Grid")
                       }
                    }
                },
                actions = {
                  if(!habiliteDelete){
                      DropdownMenuHome(
                          onClickDelete = {
                              habiliteDelete = true
                              event(HomeEvent.LoadChecable)
                          },

                      )
                  } else{
                      IconButton(onClick = {habiliteDelete = false}) {
                          Icon(imageVector = Icons.Filled.Clear, contentDescription = "Cancelar o modo de apagar notas")
                      }
                      IconButton(onClick = {
                          habiliteDelete = false
                          event(HomeEvent.DeleteNotes)
                      }) {
                          Icon(imageVector = Icons.Filled.Done, contentDescription = "Confirmar e apagar Notas")
                      }
                  }
                }
            )
        },
        floatingActionButton = { BtnAddNota(color = ColorBtnAddNota) { onNavigateAddNota()} }
    ) { paddingValues ->
           AnimatedVisibility(
               visible = layoutGrid,
               enter = fadeIn(initialAlpha = 0.4f),
               exit = fadeOut(animationSpec = tween(durationMillis = 300)
               )) {
               NotasList(
                   modifier = Modifier
                       .padding(paddingValues)
                       .padding(horizontal = 20.dp),
                   notas = notas,
                   checkVisible = habiliteDelete,
                   onClick = { nota -> onNavigateDetails(nota)},
                   checable = state.checable
               )
           }

            AnimatedVisibility(
                visible = !layoutGrid,
                enter = fadeIn(initialAlpha = 0.4f),
                exit = fadeOut(animationSpec = tween(durationMillis = 300)
                )) {
                NotasGrid(
                    modifier = Modifier
                        .padding(paddingValues)
                        .padding(horizontal = 20.dp),
                    notas = notas,
                    checkVisible = habiliteDelete,
                    onClick = { nota -> onNavigateDetails(nota)},
                    checable = state.checable
                )
            }

    }
}

/*


@Preview
@Composable
private fun HomeScreenPrev() {
    AnotaAiTheme {
        HomeScreen({},{}, flowOf(notasTest))
    }
}*/
