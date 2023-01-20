package com.example.breakingbadapp.presentation.screen.home

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.UiMode
import com.example.breakingbadapp.R
import com.example.breakingbadapp.ui.theme.topAppBarBackgroundColor
import com.example.breakingbadapp.ui.theme.topAppBarContentColor


@Composable
fun HomeTopBar(onSearchClicked: ()->Unit){
    TopAppBar(
        title = {
            Text(
                text = "Explore",
                color = MaterialTheme.colors.topAppBarContentColor

            )
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor,
        actions = {
            IconButton(
                onClick = onSearchClicked
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = stringResource(R.string.search_icon)
                )
                
            }
        }

    )
}

@Composable
@Preview
fun HomeTopBarPreview(){
    HomeTopBar{

    }
}
@Composable
@Preview(uiMode = UI_MODE_NIGHT_YES)
fun HomeTopBarDarkPreview(){
    HomeTopBar{

    }
}