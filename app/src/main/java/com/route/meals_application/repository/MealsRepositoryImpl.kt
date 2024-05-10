package com.route.meals_application.repository

import com.route.meals_application.api.WebService
import com.route.meals_application.contracts.MealsRepository
import com.route.meals_application.models.Category
import javax.inject.Inject

class MealsRepositoryImpl @Inject constructor(
    private val webService: WebService
)
    : MealsRepository {
    override suspend fun getMeals(): List<Category> {
       return try {
           webService.fetchMeals()
       }catch (e:Exception){
           throw e
       }
    }
}