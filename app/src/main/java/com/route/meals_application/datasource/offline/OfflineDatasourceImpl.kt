package com.route.meals_application.datasource.offline

import com.route.meals_application.contracts.OffLineDatasource
import com.route.meals_application.database.MealsDatabase
import com.route.meals_application.models.Category
import com.route.meals_application.models.CategoryDB
import javax.inject.Inject

class OfflineDatasourceImpl @Inject constructor(
    private val mealsDatabase: MealsDatabase
)
    : OffLineDatasource {
    override suspend fun saveMeals(list: List<Category>) {
        val categoryDB = list.map { it.toCategoryDB() }
        mealsDatabase.getMealsDao().saveMeals(categoryDB)
    }

    override suspend fun getCachedMeals(): List<Category> {
        val categoryDB = mealsDatabase.getMealsDao().getMeals().map {
            it.toCategory()
        }
        return categoryDB
    }
}