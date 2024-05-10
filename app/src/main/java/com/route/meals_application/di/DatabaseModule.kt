package com.route.meals_application.di

import com.route.meals_application.database.MealsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabaseInstance():MealsDatabase{
        return MealsDatabase.getInstance()
    }
}