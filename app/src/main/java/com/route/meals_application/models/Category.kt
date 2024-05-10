package com.route.meals_application.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Category(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val idCategory: String?=null,
    val strCategory: String?=null,
    val strCategoryDescription: String?=null,
    val strCategoryThumb: String?=null
)