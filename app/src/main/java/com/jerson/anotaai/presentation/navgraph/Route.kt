package com.jerson.anotaai.presentation.navgraph

sealed class Route(
    val route: String,
) {
    data object HomeScreen : Route("HomeScreen")
    data object DetailsScreen: Route("DetailsScreen/{notaJson}")
    data object CreateNotaScreen: Route("CreateNotaScreen")
}