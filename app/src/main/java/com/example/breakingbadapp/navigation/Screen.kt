package com.example.breakingbadapp.navigation

sealed class Screen(val  route:String){
    object Splash: Screen("splash_screen")
    object Welcome:Screen("welcome_screen")
    object Home:Screen("home_screen")
    object Details:Screen("detail_screen/{charactersId}"){
        fun passCharacterId(charactersId : Int) :String{
            return "detail_screen/$charactersId"
        }
    }

    object Search:Screen("search_screen")

}
