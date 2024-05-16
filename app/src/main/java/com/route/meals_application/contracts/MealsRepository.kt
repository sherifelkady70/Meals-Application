package com.route.meals_application.contracts

import com.route.meals_application.models.Category
import com.route.meals_application.models.CategoryDB

interface MealsRepository {
    suspend fun getMeals() : List<Category>
}

interface OnlineDatasource{
    suspend fun fetchMeals() : List<Category>
}

interface OffLineDatasource{
    suspend fun saveMeals(list: List<Category>)
    suspend fun getCachedMeals() : List<Category>
}