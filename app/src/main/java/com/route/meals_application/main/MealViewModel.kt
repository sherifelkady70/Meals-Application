package com.route.meals_application.main

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.route.meals_application.contracts.MealsRepository
import com.route.meals_application.models.Category
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MealViewModel @Inject constructor(
    private val mealsRepo : MealsRepository
)
    : ViewModel() {
    val categoryList = mutableStateListOf<Category>()
    suspend fun getCategoryData() : List<Category>{
        return mealsRepo.getMeals()
    }
}