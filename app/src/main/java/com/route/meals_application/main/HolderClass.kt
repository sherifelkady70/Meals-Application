package com.route.meals_application.main

sealed class HolderClass(route : String) {
    data object HomeScreen : HolderClass("Home_Screen")
    data object DetailsScreen : HolderClass("Details_Screen")
}