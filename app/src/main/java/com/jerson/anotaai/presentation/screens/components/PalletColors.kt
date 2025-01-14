package com.jerson.anotaai.presentation.screens.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.jerson.anotaai.ui.theme.CardCian
import com.jerson.anotaai.ui.theme.CardGreen
import com.jerson.anotaai.ui.theme.CardPurple
import com.jerson.anotaai.ui.theme.CardRed
import com.jerson.anotaai.ui.theme.CardYellow

@Composable
fun PalletColors(
    modifier: Modifier = Modifier,
    onClick: (Color) ->Unit,
    colorNota: Color = CardYellow
) {
    val colors = listOf(CardYellow, CardPurple,  CardGreen, CardCian, CardRed)
    var principalColor by remember { mutableStateOf(colorNota) }
    var expanded by remember{ mutableStateOf(false)}
    Row(
        modifier = modifier
            .background(MaterialTheme.colorScheme.background)
            .wrapContentSize()
            .animateContentSize(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        if (expanded){
            colors.forEach{ color ->
                PalletColorItem(
                    colorInside = color,
                    colorOutside = MaterialTheme.colorScheme.background,
                    onClick = {
                        expanded = !expanded
                        principalColor = color
                        onClick(principalColor)
                    }
                )
            }
        } else{
            PalletColorItem(
                colorInside = principalColor,
                colorOutside = MaterialTheme.colorScheme.background
            ){
                expanded = !expanded
            }
        }
    }
}
