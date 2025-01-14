package com.jerson.anotaai.presentation.screens.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.snapshots.SnapshotStateMap
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jerson.anotaai.domain.model.Nota
import kotlinx.coroutines.flow.Flow

@Composable
fun NotasGrid(
    modifier: Modifier = Modifier,
    notas: Flow<List<Nota>>,
    checable: SnapshotStateMap<Int, Boolean>,
    onClick: (Nota) -> Unit,
    checkVisible: Boolean
) {
    val notasList by notas.collectAsState(initial = emptyList())
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Adaptive(minSize = 128.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        state = rememberLazyGridState()
    ) {

            items(notasList.size){ i ->
                val nota = notasList[i]
                CardNota(
                    modifier = Modifier.height(height = 130.dp),
                    nota = nota,
                    onClick = { onClick(nota) },
                    toDelete = {checable[nota.id] = it},
                    checkEnable = checable[nota.id] ?: false,
                    checkvisible = checkVisible
                )
            }

    }
}
/*

@Preview(device = "id:pixel_5", showBackground = true)
@Composable
private fun NotasListPrev() {
    AnotaAiTheme {
        NotasGrid(notas = flowOf(notasTest)){

        }
    }
}*/
