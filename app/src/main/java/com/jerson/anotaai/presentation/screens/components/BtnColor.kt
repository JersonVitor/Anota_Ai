package com.jerson.anotaai.presentation.screens.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jerson.anotaai.ui.theme.AnotaAiTheme
import com.jerson.anotaai.ui.theme.CardYellow

@Composable
fun BtnColor(
    modifier: Modifier = Modifier,
    color: Color,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier.size(40.dp),
        onClick = onClick,
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors().copy(
            containerColor = color
        )
    ){}
}

@Preview
@Composable
private fun BtnColorPrev() {
    AnotaAiTheme {
        BtnColor(color = CardYellow, onClick = {})
    }
}