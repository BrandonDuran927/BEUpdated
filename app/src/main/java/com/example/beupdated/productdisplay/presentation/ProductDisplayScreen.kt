package com.example.beupdated.productdisplay.presentation

import android.icu.text.NumberFormat
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.beupdated.R
import com.example.beupdated.productdisplay.presentation.composables.ProductItem
import com.example.beupdated.productdisplay.presentation.composables.SearchBar
import com.google.firebase.auth.FirebaseUser
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDisplayScreen(
    user: FirebaseUser?,
    action: (ProductDisplayAction) -> Unit,
    onLoggedOut: () -> Unit,
    onProductScreen: () -> Unit,
    onNotificationScreen: () -> Unit,
    onSavedProductScreen: () -> Unit,
    onSearchScreen: () -> Unit,
    onProfileScreen: () -> Unit,
    onOrderScreen: () -> Unit
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
                            // TODO:
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
                            onOrderScreen()
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
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            item {
                Image(
                    modifier = Modifier
                        .fillMaxWidth(),
                    painter = painterResource(R.drawable.homeimage),
                    contentDescription = "Home Image",
                    contentScale = ContentScale.Crop
                )
            }

            item {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            start = 10.dp,
                            top = 10.dp
                        ),
                    text = "UNIFORMS",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }

            item {
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(uniformItems) { item ->
                        ProductItem(
                            image = item.image,
                            productName = item.productName,
                            productPrice = item.productPrice,
                            onProductScreen = {
                                onProductScreen()
                            }
                        )
                    }
                }
            }

            item {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            start = 10.dp,
                            top = 10.dp
                        ),
                    text = "T-SHIRTS",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }

            item {
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(tShirtsItems) { item ->
                        ProductItem(
                            image = item.image,
                            productName = item.productName,
                            productPrice = item.productPrice,
                            onProductScreen = {
                                onProductScreen()
                            }
                        )
                    }
                }
            }

            item {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            start = 10.dp,
                            top = 10.dp
                        ),
                    text = "ACCESSORIES",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }

            item {
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(accessories) { item ->
                        ProductItem(
                            image = item.image,
                            productName = item.productName,
                            productPrice = item.productPrice,
                            onProductScreen = {
                                onProductScreen()
                            }
                        )
                    }
                }
            }

            item {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            start = 10.dp,
                            top = 10.dp
                        ),
                    text = "BAGS",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }

            item {
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(bags) { item ->
                        ProductItem(
                            image = item.image,
                            productName = item.productName,
                            productPrice = item.productPrice,
                            onProductScreen = {
                                onProductScreen()
                            }
                        )
                    }
                }
            }


            item {
                Button(
                    onClick = {
                        action(ProductDisplayAction.OnLogoutUser)
                        onLoggedOut()
                    }
                ) {
                    Text(text = "Logout")
                }
            }

        }
    }
}


@Preview
@Composable
private fun ProductDisplayPrev() {
    ProductDisplayScreen(
        user = null,
        action = {},
        onLoggedOut = {},
        onProductScreen = {},
        onNotificationScreen = {},
        onSavedProductScreen = {},
        onSearchScreen = {},
        onProfileScreen = {},
        onOrderScreen = {}
    )
}

// FIXME: Temporary only due to date

internal val uniformItems = listOf(
    Items("Tourism Suit", 400.00.toDisplayDouble(), R.drawable.tourismsuit),
    Items("Traditional Male Polo SHS", 300.00.toDisplayDouble(), R.drawable.traditionalmaleshs),
    Items("Traditional F/M Uniform", 250.00.toDisplayDouble(), R.drawable.traditionalunif),
)

internal val tShirtsItems = listOf(
    Items("White TS", 120.00.toDisplayDouble(), R.drawable.whitets),
    Items("Black TS", 120.00.toDisplayDouble(), R.drawable.blackts),
    Items("Go for the B/G TS", 180.00.toDisplayDouble(), R.drawable.bgts),
)

internal val accessories = listOf(
    Items("Plastic Water Bottle", 260.00.toDisplayDouble(), R.drawable.plasticwaterbottle),
    Items("Tumbler", 299.00.toDisplayDouble(), R.drawable.tumbler),
    Items("Hydro Coffee", 90.00.toDisplayDouble(), R.drawable.hydrocoffee),
)

internal val bags = listOf(
    Items("Sports Bag", 399.00.toDisplayDouble(), R.drawable.sportsbag),
    Items("Tote Bag", 99.00.toDisplayDouble(), R.drawable.totebag),
)

data class Items(
    val productName: String,
    val productPrice: DisplayableNumber,
    @DrawableRes val image: Int
)

data class DisplayableNumber(
    val value: Double,
    val formatted: String
)

fun Double.toDisplayDouble(): DisplayableNumber {
    val formatter = NumberFormat.getInstance(Locale.getDefault()).apply {
        minimumFractionDigits = 2
        maximumFractionDigits = 2
    }

    return DisplayableNumber(
        value = this,
        formatted = formatter.format(this)
    )
}