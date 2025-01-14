package com.jerson.anotaai.presentation.screens.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jerson.anotaai.domain.model.Nota
import com.jerson.anotaai.domain.use_cases.NotaUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
   private val notaUseCases: NotaUseCases
): ViewModel() {

    private var _state = mutableStateOf(HomeState())

    val state: State<HomeState> = _state
    val notas = notaUseCases.getNotas()

    fun onEvent(event: HomeEvent){
        when(event){
           is HomeEvent.LoadChecable -> {
               loadChecable()
           }

           is HomeEvent.DeleteNotes -> {
                viewModelScope.launch {
                    notaUseCases.deleteListNotes(*filteredNotes().toTypedArray())
                }
           }
        }
    }
    private fun loadChecable(){
        viewModelScope.launch {
            notas.collect{ lista ->
                _state.value = _state.value.copy(
                    checable = mutableStateMapOf<Int,Boolean>().apply {
                            lista.forEach { notas ->
                                this[notas.id] = false
                            }
                    }
                )
            }
        }
    }

    private suspend fun filteredNotes(): MutableList<Nota>{
        val notaList = notas.first()
        val filteredList :MutableList<Nota> = mutableListOf()
        notaList.forEach { nota ->
            val canDelete: Boolean? = _state.value.checable[nota.id]
            canDelete?.let {
                if (canDelete){
                    filteredList.add(nota)
                }
            }
        }
    return filteredList
    }

}