package com.route.meals_application.repository

import android.util.Log
import com.route.meals_application.ConnectivityChecker
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
        if (ConnectivityChecker.isNetworkAvailable()) {
            val meals = onlineDatasource.fetchMeals()
            offLineDatasource.saveMeals(meals)
            Log.e("cach data","${offLineDatasource.saveMeals(meals)}")
            return meals
        }else{
            Log.e("cach data","${offLineDatasource.getCachedMeals()}")
            return offLineDatasource.getCachedMeals()
        }
    }
}