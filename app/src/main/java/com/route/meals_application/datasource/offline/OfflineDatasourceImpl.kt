package com.route.meals_application.datasource.offline

import com.route.meals_application.contracts.OffLineDatasource
import com.route.meals_application.models.Category

class OfflineDatasourceImpl : OffLineDatasource {
    override suspend fun saveMeals(list: List<Category>) {
        TODO("Not yet implemented")
    }

    override suspend fun getCachedMeals(): List<Category> {
        TODO("Not yet implemented")
    }
}