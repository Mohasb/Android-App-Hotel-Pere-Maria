package com.example.hotelperemaria.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.hotelperemaria.nav.AppScreens


/////////////////////////// Rating no editable
@Composable
fun CardRating(rating: Int, navigator: NavController) {
    var currentRating by remember { mutableStateOf(rating) }

    Column(
        modifier = Modifier.height(48.dp), verticalArrangement = Arrangement.Center
    ) {
        Box(modifier = Modifier.clickable { navigator.navigate(AppScreens.rating.route) }) {
            LazyRow {
                item {
                    Text(
                        text = rating.toString(), style = MaterialTheme.typography.bodyLarge
                    )
                }
                items(5) { index ->
                    val starType = when {
                        currentRating >= index + 1 -> StarType.Filled
                        else -> StarType.Outlined
                    }

                    StarItem(
                        starType = starType,
                    )
                }
            }
        }
    }
}

@Composable
private fun StarItem(
    starType: StarType,
) {
    val imageVector = when (starType) {
        StarType.Filled -> Icons.Default.Star
        StarType.Outlined -> Icons.Outlined.Star
    }
    val tint = if (starType == StarType.Filled) Color.Yellow else Color.Gray

    Icon(
        imageVector = imageVector,
        contentDescription = null,
        tint = tint,
        modifier = Modifier
            .size(26.dp)
            .padding(4.dp)
    )
}

/////////////////////////////// Rating editable
@Composable
fun EditableRating(
    rating: Int, onRatingChanged: (Int) -> Unit
) {
    var currentRating by remember { mutableStateOf(rating) }

    Column(
        modifier = Modifier.height(48.dp), verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
        ) {
            LazyRow {
                item {
                    Text(
                        text = /*stringResource(id = R.string.rating)*/ rating.toString(),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
                items(5) { index ->
                    val starType = when {
                        currentRating >= index + 1 -> StarType.Filled
                        else -> StarType.Outlined
                    }

                    StarItemClickable(starType = starType, onStarClicked = {
                        currentRating = index + 1
                        onRatingChanged(currentRating)
                    })
                }
            }
        }
    }
}

@Composable
private fun StarItemClickable(
    starType: StarType, onStarClicked: () -> Unit
) {
    val imageVector = when (starType) {
        StarType.Filled -> Icons.Default.Star
        StarType.Outlined -> Icons.Outlined.Star
    }
    val tint = if (starType == StarType.Filled) Color.Yellow else Color.Gray

    Icon(imageVector = imageVector,
        contentDescription = null,
        tint = tint,
        modifier = Modifier
            .size(26.dp)
            .padding(4.dp)
            .clickable { onStarClicked() })
}

enum class StarType {
    Filled, Outlined
}