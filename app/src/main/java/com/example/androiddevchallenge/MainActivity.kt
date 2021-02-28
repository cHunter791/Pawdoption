/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.KEY_ROUTE
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.data.DogLoader
import com.example.androiddevchallenge.ui.detail.DetailPage
import com.example.androiddevchallenge.ui.list.ListPage
import com.example.androiddevchallenge.ui.theme.PawdoptionTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PawdoptionTheme {
                window.statusBarColor = MaterialTheme.colors.primaryVariant.toArgb()
                Pawdoption()
            }
        }
    }
}

@Composable
fun Pawdoption() {
    val navController = rememberNavController()
    val navState = navController.currentBackStackEntryAsState()
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Pawdoption") },
                navigationIcon = if (navState.value?.arguments?.getString(KEY_ROUTE) != "list") {
                    {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(
                                painter = painterResource(R.drawable.ic_back),
                                contentDescription = "Back"
                            )
                        }
                    }
                } else {
                    {
                        IconButton(onClick = {}) {
                            Icon(
                                painter = painterResource(R.drawable.ic_pets),
                                contentDescription = "App Icon"
                            )
                        }
                    }
                }
            )
        }
    ) {
        NavHost(navController, startDestination = "list") {
            composable("list") { ListPage(navController) }
            composable(
                "detail/{dogId}",
                arguments = listOf(navArgument("dogId") { type = NavType.IntType })
            ) { backstackEntry ->
                val dogId = backstackEntry.arguments?.getInt("dogId")
                    ?: throw IllegalStateException("dogId required")
                val dog = DogLoader.getDogs().find { dog -> dog.id == dogId }
                    ?: throw IllegalArgumentException("Invalid dogId")

                DetailPage(dog)
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    PawdoptionTheme {
        Pawdoption()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    PawdoptionTheme(darkTheme = true) {
        Pawdoption()
    }
}
