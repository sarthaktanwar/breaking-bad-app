package com.example.breakingbadapp.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.breakingbadapp.navigation.util.Constants.DETAILS_ARGUMENT_KEY
import com.example.breakingbadapp.presentation.screen.home.HomeScreen
import com.example.breakingbadapp.presentation.screen.splash.SplashScreen
import com.example.breakingbadapp.presentation.screen.welcome.WelcomeScreen
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun SetupNavGraph(navController:NavHostController){
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ){
        composable(route = Screen.Splash.route){
          SplashScreen(navController=navController)
        }
        composable(route = Screen.Welcome.route){
          WelcomeScreen(navController=navController)
        }
        composable(route = Screen.Home.route){
           HomeScreen(navController = navController)
        }
        composable(
            route = Screen.Details.route,
            arguments = listOf(navArgument(DETAILS_ARGUMENT_KEY){
                type = NavType.IntType
            })
        ){



        }
        composable(route = Screen.Search.route){

        }

    }

}