package com.route.meals_application.presentation.ui.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.route.meals_application.domain.entity.Category

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MainMealView2(category : Category) {
    Box(modifier = androidx.compose.ui.Modifier.fillMaxSize().padding(22.dp)){
        Card(
            modifier = androidx.compose.ui.Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .size(150.dp)
        ) {
            Row(modifier = androidx.compose.ui.Modifier.fillMaxWidth()) {
                GlideImage(
                    model = category.strCategoryThumb,
                    contentDescription = "Meal Image", modifier =
                    androidx.compose.ui.Modifier
                        .padding(4.dp)
                        .width(120.dp)
                        .height(120.dp)
                )

                Column(modifier = androidx.compose.ui.Modifier.padding(4.dp)) {
                    Text(
                        text = category.strCategory ?: " ",
                        modifier = androidx.compose.ui.Modifier
                            .padding(4.dp)
                    )

                    Text(
                        text = category.strCategoryDescription ?: " ",
                        modifier = androidx.compose.ui.Modifier
                            .padding(4.dp)
                            .fillMaxWidth(), maxLines = 4
                    )
                }
            }
        }
    }
}