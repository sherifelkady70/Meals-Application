package com.route.meals_application.domain.usecase

import com.route.meals_application.domain.repository.MealsRepository
import com.route.meals_application.domain.entity.Category
import javax.inject.Inject

class MealsUseCase @Inject
constructor(private val mealsRepository: MealsRepository){
    suspend fun getMeals() : List<Category>{
        return mealsRepository.getMeals()
    }
}