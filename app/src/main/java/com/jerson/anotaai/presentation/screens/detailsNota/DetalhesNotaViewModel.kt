package com.jerson.anotaai.presentation.screens.detailsNota

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jerson.anotaai.domain.model.Nota
import com.jerson.anotaai.domain.use_cases.NotaUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetalhesNotaViewModel @Inject constructor(
    private val notaUseCases: NotaUseCases
) : ViewModel(){
    private var _state = mutableStateOf(DetalhesNotaState())
    val state : State<DetalhesNotaState> = _state


    fun onEvent(event: DetalhesNotaEvent){
        when(event){
            is DetalhesNotaEvent.UpdateNota -> {
                viewModelScope.launch {
                    notaUseCases.updateNota(nota = _state.value.nota)
                }
            }
            is DetalhesNotaEvent.ModoEdicao -> {
                val edit = _state.value.edit
                _state.value =_state.value.copy(edit = !edit);
            }

            is DetalhesNotaEvent.AtualizarTexto -> {
                _state.value= _state.value.copy(
                    nota = _state.value.nota.copy(conteudo = event.conteudo)
                )
            }
            is DetalhesNotaEvent.AtualizarTitulo -> {
                _state.value= _state.value.copy(
                    nota = _state.value.nota.copy(titulo = event.titulo)
                )

            }
            is DetalhesNotaEvent.UpdateColor -> {
                _state.value = _state.value.copy(
                    nota = _state.value.nota.copy(corDaNota = event.color.value.toLong())
                )
            }

            is DetalhesNotaEvent.DeleteNota -> {
                viewModelScope.launch {
                    notaUseCases.deleteNota(_state.value.nota)
                }
            }
        }
    }
    fun atualizarStateNota(nota: Nota){
        _state.value = _state.value.copy(
            nota = nota
        )
    }


}