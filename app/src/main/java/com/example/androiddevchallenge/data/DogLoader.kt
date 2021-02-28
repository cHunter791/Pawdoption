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
package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.R
import kotlin.random.Random

object DogLoader {

    fun getDogs(): List<Dog> {
        return listOf(
            jackRussell,
            bulldog,
            goldenRetriever,
            dalmatian,
            corgi,
            jackRussell,
            bulldog,
            goldenRetriever,
            dalmatian,
            corgi,
            jackRussell,
            bulldog,
            goldenRetriever,
            dalmatian,
            corgi,
            jackRussell,
            bulldog,
            goldenRetriever,
            dalmatian,
            corgi,
        )
    }

    val jackRussell = Dog(
        id = Random.nextInt(),
        name = "Fido",
        breed = "Jack Russell",
        age = "4 years",
        image = R.drawable.jack_russell,
        description = "A very energetic dog, looking a good home.",
    )

    val bulldog = Dog(
        id = Random.nextInt(),
        name = "Greg",
        breed = "Bulldog",
        age = "1 year",
        image = R.drawable.bulldog,
        description = "Young and curious, needs a child free home to grow.",
    )

    val goldenRetriever = Dog(
        id = Random.nextInt(),
        name = "Sasha",
        breed = "Golden Retriever",
        age = "7 years",
        image = R.drawable.golden_retriever,
        description = "An old dog for a animal free home to rest.",
    )

    val dalmatian = Dog(
        id = Random.nextInt(),
        name = "Spot",
        breed = "Dalmatian",
        age = "3 years",
        image = R.drawable.dalmatian,
        description = "",
    )

    val corgi = Dog(
        id = Random.nextInt(),
        name = "Corgnelius",
        breed = "Corgi",
        age = "1 year",
        image = R.drawable.corgi,
        description = "",
    )
}
