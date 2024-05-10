package com.route.meals_application.datasource.online

import com.route.meals_application.contracts.OnlineDatasource
import com.route.meals_application.models.Category

class OnlineDatasourceImpl : OnlineDatasource {
    override suspend fun fetchMeals(): List<Category> {
        TODO("Not yet implemented")
    }
}