package com.route.meals_application.data.di

import android.util.Log
import com.route.meals_application.data.api.WebService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Singleton
    @Provides
    fun provideInterceptors() : HttpLoggingInterceptor{
       return HttpLoggingInterceptor{
           Log.e("API",it)
       }.apply {
           level = HttpLoggingInterceptor.Level.BODY
       }
    }
    @Singleton
    @Provides
    fun providesOkHttpClint(loggingInterceptor : HttpLoggingInterceptor) : OkHttpClient {
        return OkHttpClient
            .Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }
    @Singleton
    @Provides
    fun providesGsonConverterFactory() : GsonConverterFactory{
        return GsonConverterFactory.create()
    }
    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Singleton
    @Provides
    fun providesWebServices(retrofit: Retrofit) : WebService {
        return retrofit.create(WebService::class.java)
    }

}