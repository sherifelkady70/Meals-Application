package com.route.meals_application.di

import com.route.meals_application.contracts.MealsRepository
import com.route.meals_application.contracts.OffLineDatasource
import com.route.meals_application.contracts.OnlineDatasource
import com.route.meals_application.datasource.offline.OfflineDatasourceImpl
import com.route.meals_application.datasource.online.OnlineDatasourceImpl
import com.route.meals_application.repository.MealsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun providesMealsRepo(impl:MealsRepositoryImpl) : MealsRepository{
        return impl
    }

    @Singleton
    @Provides
    fun provideOnlineDatasource(impl:OnlineDatasourceImpl): OnlineDatasource{
        return impl
    }

    @Singleton
    @Provides
    fun provideOfflineDatasource(impl : OfflineDatasourceImpl) : OffLineDatasource{
        return impl
    }
}