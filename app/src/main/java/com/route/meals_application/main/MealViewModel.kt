package com.route.meals_application.main

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.route.meals_application.contracts.MealsRepository
import com.route.meals_application.models.Category
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealViewModel @Inject constructor(
    private val mealsRepo : MealsRepository
)
    : ViewModel() {
    val categoryList = mutableStateListOf<Category>()
     fun getCategoryData() {
         try{
             viewModelScope.launch(Dispatchers.IO) {
                 val meals = mealsRepo.getMeals()
                 categoryList.addAll(meals)
             }
         }catch (e:Exception){
             Log.e("MealViewModel","error in viewMOdel")
         }

    }
}