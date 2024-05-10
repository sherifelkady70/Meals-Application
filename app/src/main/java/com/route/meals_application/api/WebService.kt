package com.route.meals_application.api

import com.route.meals_application.models.Category
import retrofit2.http.GET

interface WebService {
    @GET("categories.php")
    suspend fun fetchMeals() : List<Category>
}