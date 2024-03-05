package com.example.androidtechtest.widgets

import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun showAppBar(title: String?, icon:ImageVector? = null,isMainScreen:Boolean = true,
                elevation:Dp = 0.dp,navController: NavController,
                onAddActionClicked :() ->Unit  = {},
                onButtonClicked : ()-> Unit = {}){
   TopAppBar(
       title = { Text(text = title.toString())},
               actions = {
                   IconButton(onClick = {
                       onAddActionClicked.invoke()
                   }) {
                       Icon(
                           imageVector = Icons.Default.Search,
                           contentDescription = "search icon"
                       )

                   }
               }
       )
}

