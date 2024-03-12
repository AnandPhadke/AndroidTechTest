package com.example.androidtechtest.presentation.components

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.androidtechtest.data.model.Favorite
import com.example.androidtechtest.presentation.screens.favorite.FavoriteViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowAppBar(
    title: String?, icon: ImageVector? = null, isMainScreen: Boolean = true,
    elevation: Dp = 0.dp, navController: NavController,
    onSearchClicked: () -> Unit = {},
    favoriteViewModel: FavoriteViewModel = hiltViewModel(),
    onFavoriteClicked: () -> Unit = {}
) {
    val showIt = remember {
        mutableStateOf(false)
    }
    val context = LocalContext.current
    TopAppBar(
        title = { Text(text = title.toString()) },
        actions = {
            IconButton(onClick = {
                onSearchClicked.invoke()
            }) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "search icon"
                )

            }
            IconButton(onClick = {
                onFavoriteClicked.invoke()
            }) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Favorite icon"
                )

            }
        },
        navigationIcon = {
            val isAlreadyFavList =
                favoriteViewModel.favList.collectAsState().value.filter { item ->
                    (item.city == title)
                }

            if (isAlreadyFavList.isEmpty()) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Favorite icon",
                    modifier = Modifier
                        .scale(0.9f)
                        .clickable {
                            if (title != null) {
                                favoriteViewModel
                                    .insertFavorite(
                                        Favorite(
                                            city = title, // city name
                                        )
                                    )
                                    .run {
                                        showIt.value = false
                                    }
                            }
                        }
                )
            } else {
                showIt.value = false
                Box {}
            }
            ShowToast(context = context, showIt)
        }
    )
}
@Composable
fun ShowToast(context: Context, showIt: MutableState<Boolean>) {
    if (showIt.value) {
        Toast.makeText(context, " Added to Favorites",
            Toast.LENGTH_SHORT).show()
    }
}

