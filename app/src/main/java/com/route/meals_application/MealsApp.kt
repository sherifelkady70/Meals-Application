package com.route.meals_application

import android.app.Application
import com.route.meals_application.database.MealsDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MealsApp : Application() {

    override fun onCreate() {
        super.onCreate()
        ConnectivityChecker.context = this
        MealsDatabase.init(this)
    }
}