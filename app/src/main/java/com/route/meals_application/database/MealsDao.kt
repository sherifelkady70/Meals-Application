package com.route.meals_application.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.route.meals_application.models.Category
import com.route.meals_application.models.CategoryDB

@Dao
interface MealsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMeals(list: List<CategoryDB>)
    @Query("SELECT * FROM Meals_table")
    suspend fun getMeals() : List<CategoryDB>
}