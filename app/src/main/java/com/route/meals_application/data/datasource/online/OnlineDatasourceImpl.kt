package com.route.meals_application.data.datasource.online

import com.route.meals_application.data.api.WebService
import com.route.meals_application.domain.entity.Category
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