package com.jerson.anotaai.presentation.navgraph

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.jerson.anotaai.domain.model.Nota
import com.jerson.anotaai.presentation.screens.addNota.AddNotaScreen
import com.jerson.anotaai.presentation.screens.addNota.AddNotaViewModel
import com.jerson.anotaai.presentation.screens.detailsNota.DetalhesNotaScreen
import com.jerson.anotaai.presentation.screens.detailsNota.DetalhesNotaViewModel
import com.jerson.anotaai.presentation.screens.home.HomeScreen
import com.jerson.anotaai.presentation.screens.home.HomeViewModel

@Composable
fun NavGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Route.HomeScreen.route){
        composable(Route.HomeScreen.route) {
            val homeViewModel : HomeViewModel = hiltViewModel()
            val state by homeViewModel.state
            val notas = homeViewModel.notas
            HomeScreen(
                notas = notas,
                state = state,
                onNavigateDetails = {nota ->
                    val notaJson = Uri.encode(Gson().toJson(nota))
                    navController.navigate(Route.DetailsScreen.route.replace("{notaJson}",notaJson))
                },
                onNavigateAddNota = {
                    navController.navigate(Route.CreateNotaScreen.route)
                },
                event = homeViewModel::onEvent
            )
        }
        composable(Route.CreateNotaScreen.route) {
            val viewModel : AddNotaViewModel = hiltViewModel()
            val state by viewModel.state
            AddNotaScreen(
                 onSave = {
                     navController.popBackStack()
                 },
                 onBack = {
                     navController.popBackStack()
                 },
                event = viewModel::onEvent,
                state = state
            )
        }
        composable(
            Route.DetailsScreen.route,
            arguments = listOf(navArgument("notaJson"){type = NavType.StringType})
        ) { backStackEntry ->
            val notaJson = backStackEntry.arguments?.getString("notaJson")
            val nota = Gson().fromJson(notaJson, Nota::class.java)
            val viewModel : DetalhesNotaViewModel = hiltViewModel()
            LaunchedEffect(nota) {
                viewModel.atualizarStateNota(nota)
            }
            val state by viewModel.state
            DetalhesNotaScreen(
                state = state,
                event = viewModel::onEvent,
                onBack = {
                    navController.popBackStack()
                }
            )

        }

    }
}