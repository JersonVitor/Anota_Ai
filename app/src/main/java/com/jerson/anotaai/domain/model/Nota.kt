package com.jerson.anotaai.domain.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jerson.anotaai.ui.theme.CardYellow
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "nota")
data class Nota(

    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val titulo: String = "",
    val conteudo: String = "",
    val corDaNota: Long = CardYellow.value.toLong()
) : Parcelable


val notasTest = listOf(
    Nota(
        id = 1,
        titulo = "Teste de texto",
        conteudo = "Este é um teste para saber o quão longo vai um texto e ver também se vai quebrar no meio do caminho, porque senão vou ter que limitar o tanto que vai dar pra ver.",
        corDaNota = CardYellow.value.toLong()
    ),
    Nota(
        id = 2,
        titulo = "Nota 2",
        conteudo = "Aqui está outro exemplo de uma nota com texto mais curto.Este é um teste para saber o quão longo vai um texto e ver também se vai quebrar no meio do caminho, porque senão vou ter que limitar o tanto que vai dar pra ver.",
        corDaNota = CardYellow.value.toLong()
    ),
    Nota(
        id = 3,
        titulo = "Teste de Texto",
        conteudo = "Este texto é um pouco mais longo para verificar como o sistema lida com múltiplas linhas de conteúdo e também para garantir que o layout fique adequado.",
        corDaNota = CardYellow.value.toLong()
    ),
    Nota(
        id = 4,
        titulo = "Limite de Texto",
        conteudo = "Como lidar com limites? Será que precisamos truncar ou deixar tudo visível? Testando para entender.",
        corDaNota = CardYellow.value.toLong()
    ),
    Nota(
        id = 5,
        titulo = "Exemplo Extenso",
        conteudo = "Esta nota possui um conteúdo mais extenso para realmente avaliar o comportamento do sistema em cenários onde o texto excede o espaço visual disponível.",
        corDaNota = CardYellow.value.toLong()
    ),    Nota(
        id = 1,
        titulo = "Oi",
        conteudo = "Este é um teste para saber o quão longo vai um texto e ver também se vai quebrar no meio do caminho, porque senão vou ter que limitar o tanto que vai dar pra ver.",
        corDaNota = CardYellow.value.toLong()
    ),
    Nota(
        id = 2,
        titulo = "Nota 2",
        conteudo = "Aqui está outro exemplo de uma nota com texto mais curto.Este é um teste para saber o quão longo vai um texto e ver também se vai quebrar no meio do caminho, porque senão vou ter que limitar o tanto que vai dar pra ver.",
        corDaNota = CardYellow.value.toLong()
    ),
    Nota(
        id = 3,
        titulo = "Teste de Texto",
        conteudo = "Este texto é um pouco mais longo para verificar como o sistema lida com múltiplas linhas de conteúdo e também para garantir que o layout fique adequado.",
        corDaNota = CardYellow.value.toLong()
    ),
    Nota(
        id = 4,
        titulo = "Limite de Texto",
        conteudo = "Como lidar com limites? Será que precisamos truncar ou deixar tudo visível? Testando para entender.",
        corDaNota = CardYellow.value.toLong()
    ),
    Nota(
        id = 5,
        titulo = "Exemplo Extenso",
        conteudo = "Esta nota possui um conteúdo mais extenso para realmente avaliar o comportamento do sistema em cenários onde o texto excede o espaço visual disponível.",
        corDaNota = CardYellow.value.toLong()

    ),
    Nota(
        id = 1,
        titulo = "Oi",
        conteudo = "Este é um teste para saber o quão longo vai um texto e ver também se vai quebrar no meio do caminho, porque senão vou ter que limitar o tanto que vai dar pra ver.",
        corDaNota = CardYellow.value.toLong()
    ),
    Nota(
        id = 2,
        titulo = "Nota 2",
        conteudo = "Aqui está outro exemplo de uma nota com texto mais curto.Este é um teste para saber o quão longo vai um texto e ver também se vai quebrar no meio do caminho, porque senão vou ter que limitar o tanto que vai dar pra ver.",
        corDaNota = CardYellow.value.toLong()
    ),
    Nota(
        id = 3,
        titulo = "Teste de Texto",
        conteudo = "Este texto é um pouco mais longo para verificar como o sistema lida com múltiplas linhas de conteúdo e também para garantir que o layout fique adequado.",
        corDaNota = CardYellow.value.toLong()
    ),
    Nota(
        id = 4,
        titulo = "Limite de Texto",
        conteudo = "Como lidar com limites? Será que precisamos truncar ou deixar tudo visível? Testando para entender.",
        corDaNota = CardYellow.value.toLong()
    ),
    Nota(
        id = 5,
        titulo = "Exemplo Extenso",
        conteudo = "Esta nota possui um conteúdo mais extenso para realmente avaliar o comportamento do sistema em cenários onde o texto excede o espaço visual disponível.",
        corDaNota = CardYellow.value.toLong()
    )
)
