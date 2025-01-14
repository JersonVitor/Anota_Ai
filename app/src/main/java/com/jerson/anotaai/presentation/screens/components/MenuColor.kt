package com.jerson.anotaai.presentation.screens.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jerson.anotaai.ui.theme.AnotaAiTheme
import com.jerson.anotaai.ui.theme.CardPurple

@Composable
fun AnimatedDropdownMenu() {
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.padding(16.dp)
    ) {
        Button(onClick = { expanded = !expanded }) {
            Text("Abrir Menu")
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.background(MaterialTheme.colorScheme.surface)
        ) {
            DropdownMenuItem(
                text = { BtnColor(color = CardPurple, onClick = {})},
                onClick = {
                    expanded = false
                    // Ação da Opção 1
                }
            )
            DropdownMenuItem(
                text = { Text("Opção 2") },
                onClick = {
                    expanded = false
                    // Ação da Opção 2
                }
            )
            DropdownMenuItem(
                text = { Text("Opção 3") },
                onClick = {
                    expanded = false
                    // Ação da Opção 3
                }
            )
        }
    }
}

@Preview
@Composable
private fun teste() {
    AnotaAiTheme {
        AnimatedDropdownMenu()
    }
}