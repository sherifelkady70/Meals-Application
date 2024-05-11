package com.route.meals_application.main

import android.os.Bundle
import android.widget.Toolbar
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.route.meals_application.models.Category
import com.route.meals_application.ui.theme.Meals_ApplicationTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.DelicateCoroutinesApi

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    lateinit var navHostController : NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Meals_ApplicationTheme {
                navHostController = rememberNavController()
                MainContent()
            }
        }
    }
}
@Composable
fun MainContent(){
    MainView()
}
@Composable
fun MainView(viewModel : MealViewModel = hiltViewModel()){
    LaunchedEffect(key1 = Unit) {
        viewModel.getCategoryData()
    }
        LazyColumn (modifier = Modifier.fillMaxSize()) {
            items(viewModel.categoryList.size){ position ->
                MainMealView2(category = viewModel.categoryList[position])
            }
        }

}
@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MainMealView(category : Category){
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)) {
        ConstraintLayout (modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)){
            val (image,title,description) = createRefs()
            GlideImage(model = category.strCategoryThumb,
                contentDescription = "Image Meal" ,
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center,
                modifier = Modifier
                    .padding(4.dp)
                    .width(100.dp)
                    .height(120.dp)
                    .constrainAs(image) {
                        top.linkTo(parent.top)
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
                        start.linkTo(image.end, margin = 8.dp)
                        top.linkTo(title.bottom)
                        end.linkTo(parent.end, margin = 8.dp)
                    }
                    .padding(4.dp)
                    .fillMaxWidth(), maxLines = 6)
        }
    }
}

//@OptIn(ExperimentalGlideComposeApi::class)
//@Composable
//fun MainMealView2(category : Category) {
//    Box(modifier = Modifier.fillMaxSize().padding(22.dp)){
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(8.dp)
//            .size(150.dp)
//    ) {
//        Row(modifier = Modifier.fillMaxWidth()) {
//            GlideImage(
//                model = category.strCategoryThumb,
//                contentDescription = "Meal Image", modifier =
//                Modifier
//                    .padding(4.dp)
//                    .width(120.dp)
//                    .height(120.dp)
//            )
//
//            Column(modifier = Modifier.padding(4.dp)) {
//                Text(
//                    text = category.strCategory ?: " ",
//                    modifier = Modifier
//                        .padding(4.dp)
//                )
//
//                Text(
//                    text = category.strCategoryDescription ?: " ",
//                    modifier = Modifier
//                        .padding(4.dp)
//                        .fillMaxWidth(), maxLines = 4
//                )
//            }
//        }
//    }
//}
//}


@Preview(showSystemUi = true , showBackground = true)
@Composable
fun PreviewMealView(){
        MainMealView2(Category(1,"1","Title"
            ,"Descriptionasdasd" +
                    "asdasdasddasdasdasdasdasdasdasdasdasdasdasdas" +
                    "dasdasdasdasdasdasdasdasdasd" +
                    "dasdasdasdasdadasdasdasdasdasdas" +
                    "dasdasdasdasdasdasd" +
                    "asdasdasdasdasdsdasdasdasdasdsdasdadasdasdasdasdas"))

}