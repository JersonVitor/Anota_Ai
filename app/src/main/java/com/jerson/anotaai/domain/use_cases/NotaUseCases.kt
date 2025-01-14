package com.jerson.anotaai.domain.use_cases

data class NotaUseCases(
    val insertNota: InsertNota,
    val updateNota: UpdateNota,
    val deleteNota: DeleteNota,
    val getNotas: GetNotas,
    val deleteListNotes: DeleteListNotes
)