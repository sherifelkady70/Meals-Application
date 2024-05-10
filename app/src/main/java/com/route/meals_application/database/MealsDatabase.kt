package com.route.meals_application.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.route.meals_application.models.Category

@Database([Category::class] , version = 1)
abstract class MealsDatabase : RoomDatabase(){
    abstract fun getMealsDao() : MealsDao
    companion object{
        val INSTANCE : MealsDatabase?= null
        fun init(context:Context){
            if(INSTANCE==null){
                Room.databaseBuilder(
                    context
                    ,MealsDatabase::class.java
                    ,"Meals Database"
                ).build()
            }
        }
        fun getInstance(): MealsDatabase{
            return INSTANCE!!
        }
    }

}