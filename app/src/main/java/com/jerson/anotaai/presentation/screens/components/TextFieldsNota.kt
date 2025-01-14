package com.jerson.anotaai.presentation.screens.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

@Composable
fun TextFieldNota(
    modifier: Modifier = Modifier,
    enable: Boolean = true,
    text: String,
    placeholder: String = "",
    textStyle: TextStyle,
    onChangeValue: (String) -> Unit
) {
    TextField(
        modifier = modifier,
        value = text,
        onValueChange = onChangeValue,
        textStyle = textStyle,
        colors = TextFieldDefaults.colors().copy(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            disabledContainerColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            disabledTextColor = MaterialTheme.colorScheme.onSurface
        ),
        placeholder = {
            Text(
                text = placeholder,
                style = textStyle
            )
        },
        enabled = enable


    )
}
