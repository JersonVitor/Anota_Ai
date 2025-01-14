package com.jerson.anotaai.presentation.screens.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jerson.anotaai.ui.theme.AnotaAiTheme


@Composable
fun BtnAddNota(
    modifier: Modifier = Modifier,
    color: Color,
    onClick: () -> Unit
){
    FloatingActionButton(
        modifier = modifier,
        shape = CircleShape,
        containerColor = color,
        onClick = onClick
    ) {
        Icon(
            modifier = Modifier.size(size = 30.dp),
            imageVector = Icons.Filled.Add,
            tint = Color.White,
            contentDescription = "Adicionar Nota")

    }
}


@Preview
@Composable
private fun BtnPrev() {
    AnotaAiTheme {
        BtnAddNota(
            color = Color(0xFFE8505B)
        ) { }
    }
}