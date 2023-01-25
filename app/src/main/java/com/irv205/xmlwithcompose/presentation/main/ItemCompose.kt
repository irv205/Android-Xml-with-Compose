package com.irv205.xmlwithcompose.presentation.main

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.irv205.xmlwithcompose.domain.model.CharacterDomain

@Composable
fun ItemCard(characterDomain: CharacterDomain) {
    Card(
        modifier = Modifier
            .padding(
                bottom = 9.dp,
                top = 9.dp,
                start = 5.dp,
                end = 5.dp
            )
            .fillMaxWidth()
        ,
        shape =  RoundedCornerShape(19.dp),
        elevation = 16.dp) {
        Row (
            modifier = Modifier
                .clip(RoundedCornerShape(4.dp))
                .background(MaterialTheme.colors.surface)){
            Surface(
                modifier = Modifier.size(130.dp),
                shape = RoundedCornerShape(16.dp),
                color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f),
                elevation = 19.dp,
                border = BorderStroke(1.dp, Color.Gray)) {
                Image(
                    painter = rememberAsyncImagePainter(characterDomain.image),
                    contentDescription = characterDomain.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                        .clip(shape = RoundedCornerShape(15.dp)),
                    contentScale = ContentScale.Crop)
            }
            Column(
                modifier = Modifier
                    .padding(start = 12.dp)
                    .align(Alignment.CenterVertically)) {
                Text(text = characterDomain.name,
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(
                        fontSize = (22.sp)
                    ),
                    color = Color.Black)
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                    Text(text = characterDomain.status,
                        style = typography.body2,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.padding(
                            end = 25.dp
                        )
                    )
                }
            }
        }
    }
}