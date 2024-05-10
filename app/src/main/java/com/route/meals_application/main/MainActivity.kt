package com.route.meals_application.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.route.meals_application.models.Category
import com.route.meals_application.ui.theme.Meals_ApplicationTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val mealsViewModel by viewModels<MealViewModel>()
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Meals_ApplicationTheme {
                MainView(mealsViewModel)
            }
        }
    }
}
@Composable
fun MainView(viewModel : MealViewModel = hiltViewModel()){
    LaunchedEffect(key1 = Unit) {
        viewModel.getCategoryData()
    }
    LazyColumn (modifier = Modifier.fillMaxSize()) {
        items(viewModel.categoryList.size){ position ->
            MainMealView(category = viewModel.categoryList[position])
        }
    }
}
@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MainMealView(category : Category){
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)) {
        ConstraintLayout (modifier = Modifier.padding(8.dp)){
            val (image,title,description) = createRefs()
            GlideImage(model = category.strCategoryThumb,
                contentDescription = "Image Meal" ,
                modifier = Modifier.constrainAs(image){
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom)
                })

            Text(text = category.strCategory ?: " ",
                modifier = Modifier
                    .constrainAs(title) {
                        top.linkTo(parent.top)
                        start.linkTo(image.end)
                    }
                    .padding(4.dp))

            Text(text = category.strCategoryDescription ?: " ",
                modifier = Modifier
                    .constrainAs(description) {
                        top.linkTo(title.bottom)
                        start.linkTo(image.end)
                    }
                    .padding(4.dp))
        }
    }
}


@Preview(showSystemUi = true , showBackground = true)
@Composable
fun PreviewMealView(){
    MainMealView(Category(1,"1","Title"
    ,"Description"))
}