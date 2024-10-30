package com.example.beupdated.order.presentation

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.beupdated.R
import com.example.beupdated.order.presentation.composables.OrderItem
import com.example.beupdated.productdisplay.presentation.DisplayableNumber
import com.example.beupdated.productdisplay.presentation.composables.SearchBar
import com.example.beupdated.productdisplay.presentation.toDisplayDouble

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderScreen(
    modifier: Modifier = Modifier,
    onNotificationScreen: () -> Unit,
    onSearchScreen: () -> Unit,
    onSavedProductScreen: () -> Unit,
    onProductDisplayScreen: () -> Unit,
    onProfileScreen: () -> Unit,
    onOrderDetailsScreen: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(R.color.blue)
                ),
                title = {
                    SearchBar(
                        onNotificationScreen = {
                            onNotificationScreen()
                        },
                        onSearchScreen = {
                            onSearchScreen()
                        }
                    )
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = colorResource(R.color.blue)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {

                    IconButton(
                        onClick = {
                            onSavedProductScreen()
                        }
                    ) {
                        Icon(
                            modifier = Modifier.size(40.dp),
                            imageVector = Icons.Outlined.Star,
                            contentDescription = "Saved Button",
                            tint = Color.White
                        )
                    }

                    Spacer(Modifier.width(50.dp))

                    IconButton(
                        onClick = {
                            onProductDisplayScreen()
                        }
                    ) {
                        Icon(
                            modifier = Modifier.size(40.dp),
                            imageVector = Icons.Outlined.Home,
                            contentDescription = "Home Button",
                            tint = Color.White
                        )
                    }

                    Spacer(Modifier.width(50.dp))

                    IconButton(
                        onClick = {
                            // TODO:
                        }
                    ) {
                        Image(
                            modifier = Modifier.size(40.dp),
                            painter = painterResource(R.drawable.orderlogo),
                            contentDescription = "Order Button"
                        )

                    }

                    Spacer(Modifier.width(50.dp))

                    IconButton(
                        onClick = {
                            onProfileScreen()
                        }
                    ) {
                        Icon(
                            modifier = Modifier.size(40.dp),
                            imageVector = Icons.Outlined.Person,
                            contentDescription = "Profile Button",
                            tint = Color.White
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            items(items) { item ->
                OrderItem(
                    status = item.status,
                    productName = item.name,
                    productSize = item.size,
                    qty = item.qty,
                    image = item.image,
                    totalPrice = item.totalPrice,
                    onOrderDetailScreen = {
                        onOrderDetailsScreen()
                    }
                )

                HorizontalDivider(Modifier.fillMaxWidth())
            }
        }
    }
}

@Preview
@Composable
private fun Prev() {
    OrderScreen(
        onSearchScreen = {},
        onNotificationScreen = {},
        onSavedProductScreen = {},
        onProductDisplayScreen = {},
        onProfileScreen = {},
        onOrderDetailsScreen = {}
    )
}

internal val items = listOf(
    OrderModel(
        image = R.drawable.traditionalunif,
        size = "Large",
        name = "Traditional F/M Uniform SHS",
        status = "Pending",
        totalPrice = 249.00.toDisplayDouble(),
        qty = "1"
    ),
    OrderModel(
        image = R.drawable.traditionalunif,
        size = "Medium",
        name = "Traditional F/M Uniform SHS",
        status = "Canceled Successfully",
        totalPrice = 249.00.toDisplayDouble(),
        qty = "1"
    ),
    OrderModel(
        image = R.drawable.sportsbag,
        size = "Large",
        name = "National University Sports Bag",
        status = "Order Completed",
        totalPrice = 399.00.toDisplayDouble(),
        qty = "1"
    ),
)

internal data class OrderModel(
    @DrawableRes val image: Int,
    val size: String,
    val name: String,
    val status: String,
    val totalPrice: DisplayableNumber,
    val qty: String
)