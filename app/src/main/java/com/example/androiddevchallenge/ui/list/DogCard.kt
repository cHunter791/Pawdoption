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
package com.example.androiddevchallenge.ui.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.Dog
import com.example.androiddevchallenge.data.DogLoader
import com.example.androiddevchallenge.ui.theme.PawdoptionTheme

@Composable
fun DogCard(
    dog: Dog,
    onClicked: (Dog) -> Unit
) {
    Card(
        modifier = Modifier
            .clickable { onClicked(dog) }
            .fillMaxWidth()
            .height(100.dp)
    ) {
        Row {
            Image(
                painter = painterResource(id = dog.image),
                contentDescription = "Dog Image",
                modifier = Modifier
                    .size(100.dp)
                    .border(4.dp, MaterialTheme.colors.primary, MaterialTheme.shapes.small),
                contentScale = ContentScale.Crop,
            )
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(start = 8.dp)
            ) {
                Text(
                    "Name: ${dog.name}",
                    modifier = Modifier.weight(1f),
                    style = MaterialTheme.typography.subtitle1
                )
                Text(
                    "Breed: ${dog.breed}",
                    modifier = Modifier.weight(1f),
                    style = MaterialTheme.typography.subtitle2
                )
                Text(
                    "Age: ${dog.age}",
                    modifier = Modifier.weight(1f),
                    style = MaterialTheme.typography.subtitle2
                )
            }
        }
    }
}

@Preview("Light Theme")
@Composable
fun DogCardLightPreview() {
    PawdoptionTheme {
        DogCard(DogLoader.corgi) {}
    }
}

@Preview("Dark Theme")
@Composable
fun DogCardDarkPreview() {
    PawdoptionTheme(darkTheme = true) {
        DogCard(DogLoader.corgi) {}
    }
}
