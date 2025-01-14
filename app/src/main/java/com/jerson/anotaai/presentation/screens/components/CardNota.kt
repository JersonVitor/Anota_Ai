package com.jerson.anotaai.presentation.screens.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jerson.anotaai.domain.model.Nota
import com.jerson.anotaai.domain.model.notasTest
import com.jerson.anotaai.ui.theme.AnotaAiTheme

enum class View{
    WideCardNota,
    StandardCardNota
}




@Composable
fun CardNota(
    nota : Nota,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    toDelete: (Boolean) -> Unit,
    checkEnable: Boolean,
    checkvisible: Boolean,
    view: View = View.StandardCardNota
){

    when(view){
        View.WideCardNota -> {
            Card(
                onClick = onClick,
                colors = CardDefaults.cardColors(
                    containerColor = Color(nota.corDaNota.toULong())
                ),
                modifier = modifier.fillMaxWidth()

            ) {
                Box(
                    modifier = Modifier.fillMaxWidth()
                ) {


                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(10.dp)
                    ) {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            color = Color.Black,
                            text = nota.titulo,
                            style = MaterialTheme.typography.titleLarge,
                        )
                        Spacer(Modifier.height(10.dp))
                        Text(
                            text = nota.conteudo,
                            color = Color.Black,
                            style = MaterialTheme.typography.labelLarge,
                            maxLines = 4,
                            softWrap = true
                        )
                    }
                    if (checkvisible){
                        Checkbox(
                            modifier = Modifier.align(Alignment.TopEnd),
                            checked = checkEnable,
                            onCheckedChange = {toDelete(it)})
                    }
                }
            }
        }
        View.StandardCardNota -> {
            Card(
                onClick = onClick,
                colors = CardDefaults.cardColors(
                    containerColor = Color(nota.corDaNota.toULong())
                ),
                modifier = modifier

            ) {
                    Box(
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        Column(
                            modifier = Modifier
                                .padding(10.dp)
                        ) {
                            Text(
                                color = Color.Black,
                                text = nota.titulo,
                                style = MaterialTheme.typography.titleLarge,
                                softWrap = true
                            )
                            Spacer(Modifier.height(10.dp))
                            Text(text = nota.conteudo,
                                color = Color.Black,
                                style = MaterialTheme.typography.labelMedium,
                                maxLines = 4,
                                softWrap = true)
                        }
                        if (checkvisible){
                        Checkbox(
                            modifier = Modifier
                                .align(Alignment.TopEnd),
                            checked = checkEnable,
                            onCheckedChange = {toDelete(it)})
                    }


                    }

                }

        }
    }

}

@Preview(device = "id:pixel_6a")
@Composable
private fun NotaPrev() {
    AnotaAiTheme {
        CardNota(
            modifier = Modifier.width(150.dp),
            nota = notasTest[0],
            onClick = { },
            toDelete = {},
            checkEnable = true,
            checkvisible = true
        )

    }
}