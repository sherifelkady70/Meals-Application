package com.route.meals_application.data.datasource.online

import com.route.meals_application.domain.entity.Category

interface OnlineDatasource {
    suspend fun fetchMeals() : List<Category>
}