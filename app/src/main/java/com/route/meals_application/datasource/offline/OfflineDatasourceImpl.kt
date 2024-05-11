package com.route.meals_application.datasource.offline

import com.route.meals_application.contracts.OffLineDatasource
import com.route.meals_application.database.MealsDatabase
import com.route.meals_application.models.Category
import javax.inject.Inject

class OfflineDatasourceImpl @Inject constructor(
    private val mealsDatabase: MealsDatabase
)
    : OffLineDatasource {
    override suspend fun saveMeals(list: List<Category>) {
        mealsDatabase.getMealsDao().saveMeals(list)
    }

    override suspend fun getCachedMeals(): List<Category> {
        return mealsDatabase.getMealsDao().getMeals()
    }
}