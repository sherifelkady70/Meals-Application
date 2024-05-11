package com.route.meals_application.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.route.meals_application.models.Category

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DetailsScreen(){
    MainDetailsView(Category(1,"1","title"
    ,"dsdsdsdsdsdsdsdsdsdsdsd"))
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MainDetailsView(category:Category){
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(12.dp)){
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)) {
            GlideImage(model = category.strCategoryThumb,
                contentDescription = "Meal Image"
                , modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp))

            Text(text = category.strCategory ?: " "
                , color = Color.Black
            ,modifier = Modifier.padding(4.dp))

            Text(text = category.strCategoryDescription ?: " "
                ,color = Color.Black
            ,modifier = Modifier.padding(8.dp))
        }
    }
}