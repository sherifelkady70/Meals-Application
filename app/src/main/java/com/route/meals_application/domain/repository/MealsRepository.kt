package com.route.meals_application.domain.repository

import com.route.meals_application.domain.entity.Category

interface MealsRepository {
    suspend fun getMeals() : List<Category>
}

