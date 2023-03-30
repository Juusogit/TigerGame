package com.example.tiikeri

sealed class Screen(val route: String) {
    object MainScreen : Screen("main_screen")
    object FinalScreen : Screen("final_screen")
    object StartScreen : Screen("start_screen")
    object AnimationScreen : Screen("animation_screen")
}