package com.example.hotelperemaria.ui.home.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.hotelperemaria.components.CardRating
import com.example.hotelperemaria.components.ImageSlider
import com.example.hotelperemaria.nav.AppScreens
import com.example.hotelperemaria.ui.home.data.network.response.RoomsResponse

@Composable
fun RoomCard(
    modifier: Modifier = Modifier,
    border: BorderStroke? = null,
    shape: Shape = MaterialTheme.shapes.medium,
    room: RoomsResponse,
    navigator: NavHostController
) {
    Card(shape = shape,
        border = border,
        modifier = modifier.clickable { navigator.navigate(AppScreens.roomDetails.route + "/" + room.type) }) {
        // Contenedor
        Column {
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(72.dp)
                    .padding(start = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(Modifier.fillMaxWidth()) {
                    // Encabezado
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Habitación ${room.type}",
                        style = MaterialTheme.typography.headlineMedium,
                        textAlign = TextAlign.Center
                    )

                    // Subtítulo
                    CompositionLocalProvider(LocalContentColor provides MaterialTheme.colorScheme.onSurface) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(end = 10.dp),
                            text = "Desde ${room.pricePerNight}€/noche",
                            style = MaterialTheme.typography.bodyMedium,
                            textAlign = TextAlign.Center

                        )
                    }
                }
            }
            //Slider imagenes
            ImageSlider(
                listOf(
                    room.imagesList[0].image1, room.imagesList[1].image2, room.imagesList[2].image3
                )
            )





            Row(Modifier.padding(start = 16.dp, end = 24.dp, top = 16.dp)) {

                // Descripción
                CompositionLocalProvider(LocalContentColor provides MaterialTheme.colorScheme.onSurface) {
                    Text(
                        text = room.description.ifEmpty {
                            "Descripción no disponible"
                        },
                        maxLines = 5,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            CompositionLocalProvider(LocalContentColor provides MaterialTheme.colorScheme.onSurface) {

                Box(
                    Modifier
                        .padding(horizontal = 8.dp)
                        .fillMaxWidth()
                ) {

                    // Botones
                    Row(
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .padding(bottom = 10.dp)
                    ) {

                        Button(onClick = { navigator.navigate(AppScreens.roomDetails.route + "/" + room.type) }) {
                            Text(
                                text = "Reservar",
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 25.sp
                            )
                        }

                    }

                    // Iconos
                    Row(
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                            .padding(bottom = 10.dp)
                    ) {

                        CardRating(rating = room.rate, navigator = navigator)


                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                Icons.Default.Share,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                    }
                }
            }
        }

    }
}