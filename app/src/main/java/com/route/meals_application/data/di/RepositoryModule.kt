package com.route.meals_application.data.di

import com.route.meals_application.data.datasource.offline.OffLineDatasource
import com.route.meals_application.data.datasource.offline.OfflineDatasourceImpl
import com.route.meals_application.data.datasource.online.OnlineDatasource
import com.route.meals_application.data.datasource.online.OnlineDatasourceImpl
import com.route.meals_application.data.repository.MealsRepositoryImpl
import com.route.meals_application.domain.repository.MealsRepository
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
    fun providesMealsRepo(impl: MealsRepositoryImpl) : MealsRepository {
        return impl
    }

    @Singleton
    @Provides
    fun provideOnlineDatasource(impl: OnlineDatasourceImpl): OnlineDatasource {
        return impl
    }

    @Singleton
    @Provides
    fun provideOfflineDatasource(impl : OfflineDatasourceImpl) : OffLineDatasource {
        return impl
    }
}