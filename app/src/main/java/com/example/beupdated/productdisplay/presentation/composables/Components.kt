package com.example.beupdated.productdisplay.presentation.composables

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.beupdated.R
import com.example.beupdated.productdisplay.presentation.DisplayableNumber
import com.example.beupdated.productdisplay.presentation.toDisplayDouble

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    onNotificationScreen: () -> Unit,
    onSearchScreen: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 30.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = "BEUpdated",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.White
            )

            Text(
                text = "Find the product you need!",
                fontWeight = FontWeight.Light,
                fontSize = 14.sp,
                color = Color.White
            )
        }

        IconButton(
            onClick = {
                onSearchScreen()
            }
        ) {
            Icon(
                modifier = Modifier.size(30.dp),
                imageVector = Icons.Rounded.Search,
                contentDescription = "Search Button",
                tint = Color.White
            )
        }

        IconButton(
            onClick = {
                onNotificationScreen()
            }
        ) {
            Icon(
                modifier = Modifier.size(30.dp),
                imageVector = Icons.Rounded.Notifications,
                contentDescription = "Notification Button",
                tint = Color.White
            )
        }
    }
}

@Composable
fun ProductItem(
    modifier: Modifier = Modifier,
    @DrawableRes image: Int,
    productName: String,
    productPrice: DisplayableNumber,
    onProductScreen: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(10.dp)
            .clickable {
                onProductScreen()
            },
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = Modifier
                .size(150.dp)
                .padding(bottom = 15.dp)
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(image),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
        Text(
            modifier = Modifier.width(150.dp),
            text = productName,

            )
        Spacer(Modifier.height(6.dp))
        Text(
            text = "P ${productPrice.formatted}",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SearchBarPrev() {
    val tmpPrice: Double = 400.00

    ProductItem(
        image = R.drawable.beupdatedlogo,
        productName = "Tourism Suit",
        productPrice = tmpPrice.toDisplayDouble(),
        onProductScreen = {}
    )
}

private val tmpPrice: Double = 400.00