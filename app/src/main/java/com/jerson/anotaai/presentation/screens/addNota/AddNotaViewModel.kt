package com.jerson.anotaai.presentation.screens.addNota


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jerson.anotaai.domain.use_cases.NotaUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AddNotaViewModel @Inject constructor(
    private val notaUseCases: NotaUseCases
) : ViewModel(){
    private var _state = mutableStateOf(AddNotaState())
    val state : State<AddNotaState> = _state

    fun onEvent(event: AddNotaEvent){
        when(event){
            is AddNotaEvent.AtualizarTitulo ->{
                _state.value= _state.value.copy(
                    nota = _state.value.nota.copy(titulo = event.titulo)
                )
            }
            is AddNotaEvent.AtualizarTexto ->{
                _state.value= _state.value.copy(
                    nota = _state.value.nota.copy(conteudo = event.conteudo)
                )
            }
            is AddNotaEvent.UpdateColor -> {
                _state.value = _state.value.copy(
                    nota = _state.value.nota.copy(
                        corDaNota = event.color.value.toLong()
                    )
                )
            }
            is AddNotaEvent.InsertNota -> {
               viewModelScope.launch {
                    notaUseCases.insertNota(_state.value.nota)
               }
            }


        }
    }


}