package com.route.meals_application.data.datasource.offline

import com.route.meals_application.domain.entity.Category

interface OffLineDatasource {
    suspend fun saveMeals(list: List<Category>)
    suspend fun getCachedMeals() : List<Category>
}