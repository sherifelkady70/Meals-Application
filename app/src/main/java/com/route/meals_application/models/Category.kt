package com.route.meals_application.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Meals_table")
data class Category(
    @PrimaryKey
    @ColumnInfo
    val idCategory: String?=null,
    @ColumnInfo
    val strCategory: String?=null,
    @ColumnInfo
    val strCategoryDescription: String?=null,
    @ColumnInfo
    val strCategoryThumb: String?=null
){
    fun toCategoryDB() : CategoryDB{
        this.apply {
            return CategoryDB(0,idCategory = idCategory, strCategory = strCategory,
                strCategoryDescription = strCategoryDescription, strCategoryThumb = strCategoryThumb)
        }
    }
}

@Entity(tableName = "Meals_table")
data class CategoryDB(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    val id : Int = 0,
    @ColumnInfo
    val idCategory: String?=null,
    @ColumnInfo
    val strCategory: String?=null,
    @ColumnInfo
    val strCategoryDescription: String?=null,
    @ColumnInfo
    val strCategoryThumb: String?=null
){
    fun toCategory() : Category{
        this.apply {
            return Category(idCategory = idCategory, strCategory = strCategory,
                strCategoryDescription = strCategoryDescription, strCategoryThumb = strCategoryThumb)
        }
    }
}