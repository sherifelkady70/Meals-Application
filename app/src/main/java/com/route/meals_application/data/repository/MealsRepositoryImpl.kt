package com.route.meals_application.data.repository

import android.util.Log
import com.route.meals_application.ConnectivityChecker
import com.route.meals_application.data.datasource.offline.OffLineDatasource
import com.route.meals_application.data.datasource.online.OnlineDatasource
import com.route.meals_application.domain.entity.Category
import com.route.meals_application.domain.repository.MealsRepository
import javax.inject.Inject

class MealsRepositoryImpl @Inject constructor(
    private val onlineDatasource: OnlineDatasource,
    private val offLineDatasource: OffLineDatasource,
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