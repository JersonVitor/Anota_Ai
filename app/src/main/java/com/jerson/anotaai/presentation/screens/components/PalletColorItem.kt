package com.jerson.anotaai.presentation.screens.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PalletColorItem(
    modifier: Modifier = Modifier,
    colorOutside: Color,
    colorInside: Color,
    onClick : () -> Unit
) {
    Canvas(
        modifier = modifier.size(50.dp).clickable { onClick() }
    ) {

        drawCircle(
            color = colorOutside,
            center = center,
            radius = size.minDimension/2f

        )
        drawCircle(
            color = colorInside,
            center = center,
            radius = (size.minDimension/2.5).toFloat()

        )
    }
}
