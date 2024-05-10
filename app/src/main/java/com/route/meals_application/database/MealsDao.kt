package com.route.meals_application.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.route.meals_application.models.Category

@Dao
interface MealsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMeals(list: List<Category>)
    @Query("SELECT * FROM Category")
    suspend fun getMeals() : List<Category>
}