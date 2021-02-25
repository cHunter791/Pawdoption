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
package com.example.androiddevchallenge.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.Dog
import com.example.androiddevchallenge.data.DogLoader
import com.example.androiddevchallenge.ui.theme.PawdoptionTheme

@Composable
fun DetailPage(dog: Dog) {
    Column {
        Image(
            painter = painterResource(id = dog.image),
            contentDescription = "Dog Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(320.dp),
            contentScale = ContentScale.Crop,
        )
        Row(
            modifier = Modifier
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                dog.name,
                modifier = Modifier.weight(2f),
                style = MaterialTheme.typography.h4,
                textAlign = TextAlign.Start,
            )

            Text(
                dog.breed,
                modifier = Modifier.weight(1f),
                style = MaterialTheme.typography.h6,
                textAlign = TextAlign.End,
            )
        }
        Text(
            dog.description,
            modifier = Modifier
                .padding(16.dp),
            style = MaterialTheme.typography.body1,
        )
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun DetailPageLightPreview() {
    PawdoptionTheme {
        DetailPage(DogLoader.corgi)
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DetailPageDarkPreview() {
    PawdoptionTheme(darkTheme = true) {
        DetailPage(DogLoader.corgi)
    }
}
