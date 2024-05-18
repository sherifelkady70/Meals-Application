package com.route.meals_application.data.api

import com.route.meals_application.domain.entity.MealsCategoriesResponse
import retrofit2.http.GET

interface WebService {
    @GET("categories.php")
    suspend fun fetchMeals() : MealsCategoriesResponse
}