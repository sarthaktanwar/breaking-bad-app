package com.example.breakingbadapp.presentation.screen.splash


import android.content.res.Configuration.UI_MODE_NIGHT_MASK
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.breakingbadapp.R
import com.example.breakingbadapp.navigation.Screen
import com.example.breakingbadapp.ui.theme.Purple500
import com.example.breakingbadapp.ui.theme.Purple700
import com.example.breakingbadapp.ui.theme.titleColor

@Composable
fun SplashScreen(
    navController: NavHostController,
splashViewModel: SplashViewModel = hiltViewModel()
){
    val onBoardingCompleted by splashViewModel.onBoardingCompleted.collectAsState()
    LaunchedEffect(key1 = true){
        navController.popBackStack()
        if(onBoardingCompleted){
            navController.navigate(Screen.Home.route)
        }else
        {
            navController.navigate(Screen.Welcome.route)
        }
    }
   Splash()

}
@Composable
fun Splash(){
    if(isSystemInDarkTheme())
    {
        Box(modifier = Modifier
            .background(Color.LightGray)
            .fillMaxSize()
        ){
            Image(painter = painterResource(id = com.example.breakingbadapp.R.drawable.avatar_bad_breaking_svgrepo_com),
                contentDescription = stringResource(com.example.breakingbadapp.R.string.app_logo),
                Modifier.padding(80.dp)
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(alignment = Alignment.Center)
                    .padding(top = 60.dp),

                text = "BREAKING BAD ",
                color = MaterialTheme.colors.titleColor,
                fontSize = MaterialTheme.typography.h2.fontSize,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontStyle = FontStyle.Italic

            )


        }
    }
    else
    {
        Box(modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
        ){
            Image(painter = painterResource(id = com.example.breakingbadapp.R.drawable.avatar_bad_breaking_svgrepo_com),
                contentDescription = stringResource(com.example.breakingbadapp.R.string.app_logo),
                Modifier.padding(80.dp)
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(alignment = Alignment.Center)
                    .padding(top = 60.dp),

                text = "BREAKING BAD ",
                color = MaterialTheme.colors.titleColor,
                fontSize = MaterialTheme.typography.h2.fontSize,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontStyle = FontStyle.Italic

            )

        }

    }
}

@Composable
@Preview
fun SplashScreenPreview() {
    Splash()
}


@Composable
@Preview(uiMode = UI_MODE_NIGHT_YES)
fun SplashScreenPreviewDark() {
    Splash()
}