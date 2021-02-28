package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R

@Composable
fun Chip(
    text: String,
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colors.surface,
    shape: Shape = MaterialTheme.shapes.small,
    imageResource: Int? = null
) {
    Card(
        modifier = modifier,
        backgroundColor = backgroundColor,
        shape = shape,
        contentColor = contentColorFor(backgroundColor = backgroundColor),
    ) {
        Row(
            modifier = Modifier
                .padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (imageResource != null) {
                Icon(
                    painter = painterResource(id = imageResource),
                    contentDescription = "Chip Icon",
                )
            }
            Text(
                text,
                modifier = Modifier
                    .padding(start = 8.dp),
                style = MaterialTheme.typography.subtitle2,
            )
        }
    }
}

@Preview
@Composable
fun ChipPreview() {
    Chip(
        "Chip!",
        imageResource = R.drawable.ic_pets
    )
}