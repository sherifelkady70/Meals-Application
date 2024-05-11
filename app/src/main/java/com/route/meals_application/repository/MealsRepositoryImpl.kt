package com.route.meals_application.repository

import com.route.meals_application.api.WebService
import com.route.meals_application.contracts.MealsRepository
import com.route.meals_application.contracts.NetworkHandler
import com.route.meals_application.contracts.OffLineDatasource
import com.route.meals_application.contracts.OnlineDatasource
import com.route.meals_application.models.Category
import javax.inject.Inject

class MealsRepositoryImpl @Inject constructor(
    private val onlineDatasource: OnlineDatasource,
    private val offLineDatasource: OffLineDatasource,
    private val networkHandler : NetworkHandler
)
    : MealsRepository {
    override suspend fun getMeals(): List<Category> {
        if (networkHandler.isOnline()) {
            val meals = onlineDatasource.fetchMeals()
            offLineDatasource.saveMeals(meals)
            return meals
        }
        return offLineDatasource.getCachedMeals()
    }
}