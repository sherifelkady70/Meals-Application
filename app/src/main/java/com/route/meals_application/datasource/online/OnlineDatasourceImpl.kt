package com.route.meals_application.datasource.online

import com.route.meals_application.api.WebService
import com.route.meals_application.contracts.OnlineDatasource
import com.route.meals_application.models.Category
import javax.inject.Inject

class OnlineDatasourceImpl
@Inject constructor(private val webService: WebService)
    : OnlineDatasource {
    override suspend fun fetchMeals(): List<Category> {
      try {
          return webService.fetchMeals().categories
      }catch (e:Exception){
          throw e
      }
    }
}