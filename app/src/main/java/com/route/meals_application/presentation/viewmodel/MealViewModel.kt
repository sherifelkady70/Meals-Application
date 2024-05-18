package com.route.meals_application.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.route.meals_application.domain.entity.Category
import com.route.meals_application.domain.usecase.MealsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealViewModel @Inject constructor(
    private val mealsUseCase: MealsUseCase
)
    : ViewModel() {
    val categoryList = mutableStateListOf<Category>()
     fun getCategoryData() {
         try{
             viewModelScope.launch(Dispatchers.IO) {
                 val meals = mealsUseCase.getMeals()
                 categoryList.addAll(meals)
             }
         }catch (e:Exception){
             Log.e("MealViewModel","error in viewMOdel")
         }

    }
}