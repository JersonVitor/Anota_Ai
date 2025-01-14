package com.jerson.anotaai.presentation.screens.home

import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.snapshots.SnapshotStateMap

data class HomeState (
    val isList: Boolean = false,
    val checable : SnapshotStateMap<Int,Boolean>  = mutableStateMapOf()
)